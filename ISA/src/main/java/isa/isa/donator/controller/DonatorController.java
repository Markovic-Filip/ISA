package isa.isa.donator.controller;

import isa.isa.donator.domain.Questionnaire;
import isa.isa.donator.dto.QuestionnaireDTO;
import isa.isa.donator.service.QuestionnaireService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class DonatorController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @GetMapping("/donator/questionnaire")
    public ResponseEntity<Questionnaire> createQuestionnaire(@RequestBody QuestionnaireDTO questionnaireDTO){
        Questionnaire questionnaire = this.questionnaireService.save(questionnaireDTO);

        return new ResponseEntity<>(questionnaire, HttpStatus.CREATED);
    }
}
