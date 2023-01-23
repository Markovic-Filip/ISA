package isa.isa.donator.service.impl;

import isa.isa.appointment.domain.Report;
import isa.isa.appointment.repository.ReportRepository;
import isa.isa.donator.domain.HistoryOfAppointments;
import isa.isa.donator.dto.HistorySuccessfulDTO;
import isa.isa.donator.mapper.HistoryMapper;
import isa.isa.donator.repository.HistoryOfAppointmentsRepository;
import isa.isa.donator.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryOfAppointmentsRepository historyOfAppointmentsRepository;
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List<HistorySuccessfulDTO> getHistory(Long donatorId) {
        HistoryOfAppointments historyOfAppointments = null;
        List<HistoryOfAppointments> ha = historyOfAppointmentsRepository.findAll();
        for (HistoryOfAppointments h : ha) {
            if (h.getDonator().getId() == donatorId) {
                historyOfAppointments = h;
            }
        }
        List<Report> reports = new ArrayList<>();
        List<Report> allReports = reportRepository.findAll();
        for (Report r : allReports) {
            if (r.getHistoryOfAppointments().equals(historyOfAppointments)) {
                reports.add(r);
            }

        }
        List<HistorySuccessfulDTO> historySuccessfulDTOS = new ArrayList<>();
        for (Report r : reports) {
            if (r.getBlood() != null) {
                historySuccessfulDTOS.add(HistoryMapper.historySuccessfulDTO(r.getAppointment()));
            }
        }

        return historySuccessfulDTOS;
    }
}


