package isa.isa.donator.service.impl;

import isa.isa.donator.domain.Questionnaire;
import isa.isa.donator.dto.QuestionnaireDTO;
import isa.isa.donator.repository.QuestionnaireRepository;
import isa.isa.donator.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Override
    public Questionnaire save(QuestionnaireDTO questionnaireDTO) {
        Questionnaire q = new Questionnaire();

        return this.questionnaireRepository.save(q);
    }

    @Override
    public Questionnaire findByDonatorId(Long donatorId) {
        List<Questionnaire> qs = this.questionnaireRepository.findAll();
        for (Questionnaire qn: qs) {
            if(qn.getDonator().getId()==donatorId){
                return qn;
            }
        }
        return null;
    }


}
