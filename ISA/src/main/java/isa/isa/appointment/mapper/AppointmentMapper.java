package isa.isa.appointment.mapper;

import isa.isa.appointment.domain.Appointment;
import isa.isa.appointment.dto.QRAppointmentDTO;
import isa.isa.user.domain.Address;
import isa.isa.user.domain.City;
import isa.isa.user.domain.Country;
import isa.isa.user.dto.AddressDTO;

public class AppointmentMapper {

    public static QRAppointmentDTO appointmentToQRAppointmentDTO(Appointment appointment){

        QRAppointmentDTO qrAppointmentDTO = new QRAppointmentDTO(appointment.getTimePeriod().getStart(), "C:\\Filip\\Fakultet\\ISA final\\qr"+appointment.getId()+".png");


        return qrAppointmentDTO;
    }
}
