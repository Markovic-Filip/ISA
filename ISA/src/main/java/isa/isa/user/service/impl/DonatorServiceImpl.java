package isa.isa.user.service.impl;

import isa.isa.QRCode.email.EmailService;
import isa.isa.donator.domain.HistoryOfAppointments;
import isa.isa.donator.domain.Questionnaire;
import isa.isa.donator.repository.HistoryOfAppointmentsRepository;
import isa.isa.donator.repository.QuestionnaireRepository;
import isa.isa.user.domain.Address;
import isa.isa.user.domain.Donator;
import isa.isa.user.domain.Role;
import isa.isa.user.domain.enumeration.Gender;
import isa.isa.user.dto.UserRequest;
import isa.isa.user.repository.DonatorRepository;
import isa.isa.user.repository.UserRepository;
import isa.isa.user.service.AddressService;
import isa.isa.user.service.DonatorService;
import isa.isa.user.service.RoleService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonatorServiceImpl implements DonatorService {

    @Autowired
    DonatorRepository donatorRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AddressService addressService;
    @Autowired
    RoleService roleService;
    @Autowired
    HistoryOfAppointmentsRepository historyOfAppointmentsRepository;
    @Autowired
    EmailService emailService;
    @Autowired
    QuestionnaireRepository questionnaireRepository;

    @Override
    public Donator save(UserRequest userRequest) {
        Donator u = new Donator();
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
        u.setJmbg(userRequest.getJmbg());
        u.setActivated(false);
        u.setRole(userRequest.getRole());
        u.setPasswordChanged(true);



        Address address = addressService.findById(userRequest.getAddress_id());
        u.setAddress(address);

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
        //u.setRole("Donator");

        String randomCode = RandomString.make(64);
        u.setVerificationCode(randomCode);
        u.setActivated(false);


        return this.userRepository.save(u);
    }

    @Override
    public void createHistoryQuestionnaire(Donator donator) {
        HistoryOfAppointments historyOfAppointments = new HistoryOfAppointments();
        Questionnaire questionnaire = new Questionnaire();
        historyOfAppointments.setDonator(donator);
        historyOfAppointmentsRepository.save(historyOfAppointments);
        questionnaire.setDonator(donator);
        questionnaire.setFilled(false);
        questionnaireRepository.save(questionnaire);
        donator.setQuestionnaire(questionnaire);
        donator.setHistoryOfAppointments(historyOfAppointments);
        donatorRepository.save(donator);
        }

    @Override
    public boolean verify(String verificationCode) {
        Donator donator = donatorRepository.findByVerificationCode(verificationCode);

        if(donator==null || donator.getActivated()){
            return false;
        }else {
            donator.setVerificationCode(null);
            donator.setActivated(true);
            donatorRepository.save(donator);
            return true;
        }
    }

}

