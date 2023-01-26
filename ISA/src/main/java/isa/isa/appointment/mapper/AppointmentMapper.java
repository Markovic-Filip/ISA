package isa.isa.appointment.mapper;

import isa.isa.appointment.domain.Appointment;
import isa.isa.appointment.dto.QRAppointmentDTO;
import isa.isa.appointment.dto.ScheduledAppointment;
import isa.isa.donator.dto.HistorySuccessfulDTO;
import isa.isa.user.domain.Address;
import isa.isa.user.domain.City;
import isa.isa.user.domain.Country;
import isa.isa.user.dto.AddressDTO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class AppointmentMapper {

    public static QRAppointmentDTO appointmentToQRAppointmentDTO(Appointment appointment){

        String path = "C:\\Filip\\Fakultet\\ISA final\\qr\\"+appointment.getId()+".png";
        String base64Image = imageToBase64(path);
        QRAppointmentDTO qrAppointmentDTO = new QRAppointmentDTO(appointment.getTimePeriod().getStart().toString(), base64Image);


        return qrAppointmentDTO;
    }

    public static String imageToBase64(String imagePath) {
        try {
            Path path = Paths.get(imagePath);
            byte[] data = Files.readAllBytes(path);
            return Base64.getEncoder().encodeToString(data);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static ScheduledAppointment appointmentToScheduledAppointment(Appointment appointment){
        String centerName = appointment.getMedicalStaff().getCenter().getName();
        String medicalStaffName = appointment.getMedicalStaff().getName() + " " + appointment.getMedicalStaff().getSurname();
        ScheduledAppointment scheduledAppointmentDTO = new ScheduledAppointment(appointment.getId(),appointment.getTimePeriod().getStart().toString(), appointment.getTimePeriod().getEnd().toString(),centerName,medicalStaffName);
        return scheduledAppointmentDTO;
    }
}
