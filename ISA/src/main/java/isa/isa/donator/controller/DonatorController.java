package isa.isa.donator.controller;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import isa.isa.QRCode.email.EmailService;
import isa.isa.appointment.domain.Appointment;
import isa.isa.appointment.dto.QRAppointmentDTO;
import isa.isa.appointment.service.AppointmentService;
import isa.isa.donator.domain.Questionnaire;
import isa.isa.donator.dto.HistorySuccessfulDTO;
import isa.isa.donator.dto.QuestionnaireDTO;
import isa.isa.donator.service.HistoryService;
import isa.isa.donator.service.QuestionnaireService;
import isa.isa.user.domain.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
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

    @GetMapping("/scheduled")
    public ResponseEntity<?> loadAll() {
        List<Appointment> appointments = this.appointmentService.getScheduledAppointmentsForDonator(1L);
        //List<CenterDTO> centerDTOS = CenterMapper.mapCenterToCenterDTO(centers);

        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<?> loadAllAvailable() {
        List<Appointment> appointments = this.appointmentService.getAllAvailable();

        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/questionnaire")
    public ResponseEntity<Questionnaire> createQuestionnaire(@RequestBody QuestionnaireDTO questionnaireDTO){
        Questionnaire questionnaire = this.questionnaireService.save(questionnaireDTO);

        return new ResponseEntity<>(questionnaire, HttpStatus.CREATED);
    }

    @PostMapping(value = "/scheduleAppointment", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> scheduleAppointment(@RequestBody Long appointmentId) throws MessagingException, NotFoundException, IOException, WriterException {
        Long donatorId = 100L;
        this.appointmentService.scheduleAppointment(appointmentId,donatorId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/cancelAppointment", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cancelPatient(@RequestBody Long appointmentId) throws MessagingException, NotFoundException, IOException, WriterException {
        Long donatorId = 1L;
        this.appointmentService.cancelAppointment(appointmentId,donatorId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/qrAppointments")
    public ResponseEntity<?> getQRAppointments(){
        //dodaj id donatora
        List<QRAppointmentDTO> appointmentDTOS = appointmentService.getQRAppointments(1L);

        return new ResponseEntity<>(appointmentDTOS, HttpStatus.OK);
    }

    @GetMapping("/History")
    public ResponseEntity<?> getHistory(){
        //dodaj id donatora
        Long donatorId=null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof User) {
            donatorId = ((User) principal).getId();
            // use userId
        }

        List<HistorySuccessfulDTO> historySuccessfulDTOS = historyService.getHistory(donatorId);

        return new ResponseEntity<>(historySuccessfulDTOS, HttpStatus.OK);
    }


}
