package isa.isa.user.controller;

import javax.servlet.http.HttpServletResponse;

import isa.isa.QRCode.email.EmailService;
import isa.isa.user.repository.DonatorRepository;
import isa.isa.user.service.AddressService;
import isa.isa.user.service.DonatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import isa.isa.user.dto.JwtAuthenticationRequest;
import isa.isa.user.dto.UserRequest;
import isa.isa.user.dto.UserTokenState;
import isa.isa.user.exception.ResourceConflictException;
import isa.isa.user.domain.User;
import isa.isa.user.service.UserService;
import isa.isa.user.util.TokenUtils;

//Kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;
	@Autowired
	private DonatorService donatorService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private DonatorRepository donatorRepository;

	@Autowired
	private AddressService addressService;
	
	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

		// Ukoliko kredencijali nisu ispravni, logovanje nece biti uspesno, desice se
		// AuthenticationException
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		User existUser = this.userService.findByUsername(authenticationRequest.getUsername());
		if (existUser.getActivated()==false) {
			throw new ResourceConflictException(existUser.getId(), "Account is not activated on email");
		}
		// Ukoliko je autentifikacija uspesna, ubaci korisnika u trenutni security
		// kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token za tog korisnika
		User user = (User) authentication.getPrincipal();
		String jwt = tokenUtils.generateToken(user.getUsername());
		int expiresIn = tokenUtils.getExpiredIn();

		// Vrati token kao odgovor na uspesnu autentifikaciju
		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
	}

	// Endpoint za registraciju novog korisnika
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody UserRequest userRequest, UriComponentsBuilder ucBuilder) {

		User existUser = this.userService.findByUsername(userRequest.getUsername());
		userRequest.setRole("Donator");
		if (existUser != null) {
			throw new ResourceConflictException(userRequest.getId(), "Username already exists");
		}

		if (!userRequest.getPassword().equals( userRequest.getPasswordAgain())) {
			throw new ResourceConflictException(userRequest.getId(), "Passwords doesnt match");
		}
		try {
			User user = this.donatorService.save(userRequest);
			this.donatorService.createHistoryQuestionnaire(this.donatorRepository.getDonatorByUsername(userRequest.getUsername()));
			this.emailService.sendVerificationEmail(this.donatorRepository.getDonatorByUsername(userRequest.getUsername()));

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/verify")
	public String verifyUser(@Param("code") String code){
		if(donatorService.verify(code)){
			return "verify_success";
		}else{
			return "verify_fail";
		}
	}

}