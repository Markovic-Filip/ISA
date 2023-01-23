package isa.isa.user.service.impl;

import java.util.List;

import isa.isa.user.service.AddressService;
import isa.isa.user.domain.Address;
import isa.isa.user.domain.Donator;
import isa.isa.user.domain.enumeration.Gender;
import isa.isa.user.repository.DonatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import isa.isa.user.dto.UserRequest;
import isa.isa.user.domain.Role;
import isa.isa.user.domain.User;
import isa.isa.user.repository.UserRepository;
import isa.isa.user.service.RoleService;
import isa.isa.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DonatorRepository donatorRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleService roleService;

	@Autowired
	private AddressService addressService;

	@Override
	public User findByEmail(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email);
	}

	public User findById(Long id) throws AccessDeniedException {
		return userRepository.findById(id).orElseGet(null);
	}

	@Override
	public User findByUsername(String username) {
		return null;
	}

	public List<User> findAll() throws AccessDeniedException {
		return userRepository.findAll();
	}


	@Override
	public User save(UserRequest userRequest) {
		User u = new User();
		u.setUsername(userRequest.getUsername());
		
		// pre nego sto postavimo lozinku u atribut hesiramo je kako bi se u bazi nalazila hesirana lozinka
		// treba voditi racuna da se koristi isi password encoder bean koji je postavljen u AUthenticationManager-u kako bi koristili isti algoritam
		u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		
		u.setName(userRequest.getName());
		u.setSurname(userRequest.getSurnname());
		u.setEmail(userRequest.getEmail());
		u.setPhoneNumber(userRequest.getPhoneNumber());
		u.setJmbg(userRequest.getJmbg());
		u.setProfession(userRequest.getProffesion());
		u.setCompany(userRequest.getCompany());

		Address adress = addressService.findById(userRequest.getAddress_id());
		u.setAddress(adress);

		if(userRequest.getGender().trim().toLowerCase().equals("male")){
			u.setGender(Gender.MALE);
		} else if (userRequest.getGender().trim().toLowerCase().equals("female")) {
			u.setGender(Gender.FEMALE);
		}else {
			u.setGender(Gender.OTHER);
		}


		// u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
		List<Role> roles = roleService.findByName("ROLE_USER");
		u.setRoles(roles);
		
		return this.userRepository.save(u);
	}

	@Override
	public int penaltys(Long id) {
		Donator d = donatorRepository.getById(id);
		int penalty = d.getPenaltys();

		return penalty;
	}

}
