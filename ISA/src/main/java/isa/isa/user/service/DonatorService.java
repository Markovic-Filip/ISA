package isa.isa.user.service;

import isa.isa.user.domain.Donator;
import isa.isa.user.dto.UserRequest;

public interface DonatorService {
    Donator save(UserRequest userRequest);
    void createHistoryQuestionnaire(Donator donator);

    public boolean verify(String verificationCode);

}
