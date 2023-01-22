package isa.isa.appointment.service.impl;

import isa.isa.appointment.domain.Appointment;
import isa.isa.appointment.domain.enumeration.AppointmentState;
import isa.isa.appointment.repository.AppointmentRepository;
import isa.isa.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getScheduledAppointmentsForDonator(Long donatorId) {
        List<Appointment> appointments = new ArrayList<Appointment>();
        List<Appointment> allAppointments = appointmentRepository.findAll();
        for (Appointment a : allAppointments) {
            if (a.getDonator().getId() == donatorId/* && a.getAppointmentState() == AppointmentState.CREATED*/) {
                appointments.add(a);
            }
        }
        return appointments;
    }

    @Override
    public List<Appointment> getAllAvailable() {
        List<Appointment> appointments = new ArrayList<Appointment>();
        List<Appointment> allAppointments = appointmentRepository.findAll();
        for (Appointment a : allAppointments) {
            if (a.getAppointmentState()== AppointmentState.CREATED) {
                appointments.add(a);
            }
        }
        return appointments;
    }

}
