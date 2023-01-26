package isa.isa.donator.mapper;

import isa.isa.appointment.domain.Appointment;
import isa.isa.donator.dto.HistorySuccessfulDTO;
import isa.isa.user.domain.Address;
import isa.isa.user.dto.AddressDTO;

public class HistoryMapper {

    public static HistorySuccessfulDTO historySuccessfulDTO(Appointment appointment){
        String centerName = appointment.getMedicalStaff().getCenter().getName();
        String medicalStaffName = appointment.getMedicalStaff().getName() + " " + appointment.getMedicalStaff().getSurname();
        HistorySuccessfulDTO historyDTO = new HistorySuccessfulDTO(appointment.getTimePeriod().getStart().toString(), appointment.getTimePeriod().getEnd().toString(),centerName,medicalStaffName);
        return historyDTO;
    }
}
