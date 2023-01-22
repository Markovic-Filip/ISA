package isa.isa.appointment.service;

import isa.isa.appointment.domain.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getScheduledAppointmentsForDonator(Long donatorId);
    List<Appointment> getAllAvailable();
}
