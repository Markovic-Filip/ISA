package isa.isa.appointment.service;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import isa.isa.appointment.domain.Appointment;
import isa.isa.appointment.dto.QRAppointmentDTO;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface AppointmentService {
    List<Appointment> getScheduledAppointmentsForDonator(Long donatorId);
    List<Appointment> getAllAvailable();
    List<QRAppointmentDTO> getQRAppointments(Long donatorId);

    void scheduleAppointment(Long appointmentId, Long donatorId) throws NotFoundException, IOException, WriterException, MessagingException;

    void cancelAppointment(Long appointmentId, Long donatorId);
}
