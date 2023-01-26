package isa.isa.donator.controller;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import isa.isa.QRCode.email.EmailService;
import isa.isa.appointment.domain.Appointment;
import isa.isa.appointment.dto.QRAppointmentDTO;
import isa.isa.appointment.dto.ScheduledAppointment;
import isa.isa.appointment.service.AppointmentService;
import isa.isa.donator.domain.Questionnaire;
import isa.isa.donator.dto.CancelAppointmentRequest;
import isa.isa.donator.dto.HistorySuccessfulDTO;
import isa.isa.donator.dto.QuestionnaireDTO;
import isa.isa.donator.service.HistoryService;
import isa.isa.donator.service.QuestionnaireService;
import isa.isa.user.domain.User;
import isa.isa.user.dto.UserInformation;
import isa.isa.user.mapper.UserMapper;
import isa.isa.user.repository.DonatorRepository;
import isa.isa.user.repository.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.mail.MessagingException;
import javax.mail.search.MessageIDTerm;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/donator", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class DonatorController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DonatorRepository donatorRepository;

    @GetMapping("/scheduled")
    public ResponseEntity<?> loadAll(@RequestParam("username") String username){
        User u= userRepository.findByUsername(username);
        List<ScheduledAppointment> appointments = this.appointmentService.getScheduledAppointmentsForDonator(u.getId());
        //List<CenterDTO> centerDTOS = CenterMapper.mapCenterToCenterDTO(centers);

        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<?> loadAllAvailable(@RequestParam("center") Long centerId) {
        List<ScheduledAppointment> appointments = this.appointmentService.getAllAvailable(centerId);

        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @PostMapping(value="/questionnaire", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createQuestionnaire(@RequestBody QuestionnaireDTO questionnaireDTO, UriComponentsBuilder ucBuilder){
        Questionnaire questionnaire = this.questionnaireService.save(questionnaireDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/scheduleAppointment", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> scheduleAppointment(@RequestBody CancelAppointmentRequest request) throws MessagingException, NotFoundException, IOException, WriterException {
        User u= userRepository.findByUsername(request.getUsername());
        this.appointmentService.scheduleAppointment(request.getAppointmentId(), u.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/cancelAppointment", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cancelPatient(@RequestBody CancelAppointmentRequest request) throws MessagingException, NotFoundException, IOException, WriterException {
        User u= userRepository.findByUsername(request.getUsername());
        this.appointmentService.cancelAppointment(request.getAppointmentId(), u.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/qrAppointments")
    public ResponseEntity<?> getQRAppointments(@RequestParam("username") String username){

        Long donatorId= userRepository.findByUsername(username).getId();
        List<QRAppointmentDTO> appointmentDTOS = appointmentService.getQRAppointments(donatorId);

        return new ResponseEntity<>(appointmentDTOS, HttpStatus.OK);
    }
    @GetMapping("/History")
    public ResponseEntity<?> getHistory(@RequestParam("username") String username){
        //dodaj id donatora
        Long donatorId= userRepository.findByUsername(username).getId();

        List<HistorySuccessfulDTO> historySuccessfulDTOS = historyService.getHistory(donatorId);

        return new ResponseEntity<>(historySuccessfulDTOS, HttpStatus.OK);
    }
    @GetMapping("/penalty")
    public ResponseEntity<?> getPenalty(@RequestParam("username") String username){
        //dodaj id donatora
        Long donatorId= userRepository.findByUsername(username).getId();

        int penalty = donatorRepository.getById(donatorId).getPenaltys();

        return new ResponseEntity<>(penalty, HttpStatus.OK);
    }

    @GetMapping("/information")
    public ResponseEntity<?> getInfromation(@RequestParam("username") String username){
        User u= userRepository.findByUsername(username);

        UserInformation ui = UserMapper.mapUserToUserInformation(u);

        return new ResponseEntity<>(ui, HttpStatus.OK);
    }


}
