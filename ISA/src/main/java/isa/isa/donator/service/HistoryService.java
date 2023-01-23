package isa.isa.donator.service;

import isa.isa.donator.dto.HistorySuccessfulDTO;

import java.util.List;

public interface HistoryService {
    List<HistorySuccessfulDTO> getHistory(Long donatorId);
}
