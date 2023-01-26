package isa.isa.donator.service.impl;

import isa.isa.donator.domain.Questionnaire;
import isa.isa.donator.dto.QuestionnaireDTO;
import isa.isa.donator.repository.QuestionnaireRepository;
import isa.isa.donator.service.QuestionnaireService;
import isa.isa.user.domain.Donator;
import isa.isa.user.domain.User;
import isa.isa.user.repository.DonatorRepository;
import isa.isa.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    private DonatorRepository donatorRepository;

    @Override
    public Questionnaire save(QuestionnaireDTO questionnaireDTO) {
        Donator d = donatorRepository.getDonatorByUsername(questionnaireDTO.getUsername()) ;

        Questionnaire q = questionnaireRepository.getById(d.getQuestionnaire().getId());
        q.setQ1(questionnaireDTO.getQ1());
        q.setQ2(questionnaireDTO.getQ2());
        q.setQ3(questionnaireDTO.getQ3());
        q.setQ4(questionnaireDTO.getQ4());
        q.setQ5(questionnaireDTO.getQ5());
        q.setQ6(questionnaireDTO.getQ6());
        q.setQ7(questionnaireDTO.getQ7());
        q.setQ8(questionnaireDTO.getQ8());
        q.setQ9(questionnaireDTO.getQ9());
        q.setQ10(questionnaireDTO.getQ10());
        q.setQ11(questionnaireDTO.getQ11());
        q.setQ12(questionnaireDTO.getQ12());
        q.setFilled(true);

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
