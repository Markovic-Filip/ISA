package isa.isa.donator.service;


import isa.isa.donator.domain.Questionnaire;
import isa.isa.donator.dto.QuestionnaireDTO;


import java.util.List;

public interface QuestionnaireService {

    Questionnaire save(QuestionnaireDTO questionnaireDTO);

    Questionnaire findByDonatorId(Long donatorId);

}
