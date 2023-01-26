package isa.isa.appointment.mapper;

import isa.isa.appointment.domain.Appointment;
import isa.isa.appointment.dto.QRAppointmentDTO;
import isa.isa.appointment.dto.ScheduledAppointment;
import isa.isa.donator.dto.HistorySuccessfulDTO;
import isa.isa.user.domain.Address;
import isa.isa.user.domain.City;
import isa.isa.user.domain.Country;
import isa.isa.user.dto.AddressDTO;

public class AppointmentMapper {

    public static QRAppointmentDTO appointmentToQRAppointmentDTO(Appointment appointment){

        QRAppointmentDTO qrAppointmentDTO = new QRAppointmentDTO(appointment.getTimePeriod().getStart(), "C:\\Filip\\Fakultet\\ISA final\\qr"+appointment.getId()+".png");


        return qrAppointmentDTO;
    }

    public static ScheduledAppointment appointmentToScheduledAppointment(Appointment appointment){
        String centerName = appointment.getMedicalStaff().getCenter().getName();
        String medicalStaffName = appointment.getMedicalStaff().getName() + " " + appointment.getMedicalStaff().getSurname();
        ScheduledAppointment scheduledAppointmentDTO = new ScheduledAppointment(appointment.getId(),appointment.getTimePeriod().getStart().toString(), appointment.getTimePeriod().getEnd().toString(),centerName,medicalStaffName);
        return scheduledAppointmentDTO;
    }
}
