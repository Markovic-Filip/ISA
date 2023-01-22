package isa.isa.donator.controller;

import isa.isa.appointment.domain.Appointment;
import isa.isa.appointment.service.AppointmentService;
import isa.isa.donator.domain.Questionnaire;
import isa.isa.donator.dto.QuestionnaireDTO;
import isa.isa.donator.service.QuestionnaireService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/donator", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class DonatorController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private AppointmentService appointmentService;

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
}
