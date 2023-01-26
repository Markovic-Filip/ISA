package isa.isa.appointment.service.impl;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import isa.isa.QRCode.GenerateQrCode;
import isa.isa.QRCode.email.EmailService;
import isa.isa.appointment.domain.Appointment;
import isa.isa.appointment.domain.Report;
import isa.isa.appointment.domain.enumeration.AppointmentState;
import isa.isa.appointment.dto.QRAppointmentDTO;
import isa.isa.appointment.dto.ScheduledAppointment;
import isa.isa.appointment.mapper.AppointmentMapper;
import isa.isa.appointment.repository.AppointmentRepository;
import isa.isa.appointment.repository.ReportRepository;
import isa.isa.appointment.service.AppointmentService;
import isa.isa.bloodTransfusionCenter.repository.BloodRepository;
import isa.isa.donator.domain.HistoryOfAppointments;
import isa.isa.donator.repository.HistoryOfAppointmentsRepository;
import isa.isa.user.repository.DonatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DonatorRepository donatorRepository;
    @Autowired
    EmailService emailService;
    @Autowired
    ReportRepository reportRepository;
    @Autowired
    HistoryOfAppointmentsRepository historyOfAppointmentsRepository;



    @Override
    public List<ScheduledAppointment> getScheduledAppointmentsForDonator(Long donatorId) {
        List<ScheduledAppointment> appointments = new ArrayList<ScheduledAppointment>();
        List<Appointment> allAppointments = appointmentRepository.findAll();
        for (Appointment a : allAppointments) {
            if(a.getDonator() != null) {
                if (a.getDonator().getId() == donatorId && a.getAppointmentState() == AppointmentState.SCHEDULED) {
                    appointments.add(AppointmentMapper.appointmentToScheduledAppointment(a));
                }
            }
        }
        return appointments;
    }

    @Override
    public List<ScheduledAppointment> getAllAvailable(Long centerId) {
        List<ScheduledAppointment> appointments = new ArrayList<ScheduledAppointment>();
        List<Appointment> allAppointments = appointmentRepository.findAll();
        for (Appointment a : allAppointments) {
            if (a.getAppointmentState()== AppointmentState.CREATED && a.getMedicalStaff().getCenter().getId()==centerId) {
                appointments.add(AppointmentMapper.appointmentToScheduledAppointment(a));
            }
        }
        return appointments;
    }

    @Override
    public List<QRAppointmentDTO> getQRAppointments(Long donatorId) {
        List<QRAppointmentDTO> appointments = new ArrayList<QRAppointmentDTO>();
        List<Appointment> allAppointments = appointmentRepository.findAll();
        for (Appointment a : allAppointments) {
            if(a.getDonator()!=null) {
                if (a.getDonator().getId() == donatorId) {
                    appointments.add(AppointmentMapper.appointmentToQRAppointmentDTO(a));
                }
            }
        }
        return appointments;
    }

    @Override
    public void scheduleAppointment(Long appointmentId, Long donatorId) throws NotFoundException, IOException, WriterException, MessagingException {
        Appointment appointment = appointmentRepository.getById(appointmentId);

        appointment.setDonator(donatorRepository.getById(donatorId));
        appointment.setAppointmentState(AppointmentState.SCHEDULED);
        appointmentRepository.save(appointment);
        String centerName = appointment.getMedicalStaff().getCenter().getName();
        String medicalStaffName = appointment.getMedicalStaff().getName() + " " + appointment.getMedicalStaff().getSurname();
        String appointmentTime = appointment.getTimePeriod().toString();

        String message = "Uspesno ste zakazali termin" + "\r\n"
                       + "Naziv centra: " + centerName + "\r\n"
                       + "Ime lekara: " + medicalStaffName + "\r\n"
                       + appointmentTime;


        GenerateQrCode generateQrCode = new GenerateQrCode();
        generateQrCode.generateQrCodeAppointment(message,appointmentId.toString());
        String email = donatorRepository.getById(donatorId).getEmail();
        this.emailService.sendMessageWithAttachment(email,"Potvrda zakazivanja termina","","C:/Filip/Fakultet/ISA final/qr/"+appointmentId.toString()+".png");



    }

    @Override
    public void cancelAppointment(Long appointmentId, Long donatorId) {
        Appointment appointment = appointmentRepository.getById(appointmentId);
        Date now = new Date();
        Date beggining = appointmentRepository.getById(appointmentId).getTimePeriod().getStart();
        Long difference = beggining.getTime() - now.getTime();
        long difference_In_Hours = (difference / (1000 * 60 * 60)) % 24;

        if(difference_In_Hours<24) {
            appointment.setDonator(null);
            appointment.setAppointmentState(AppointmentState.CREATED);
            appointmentRepository.save(appointment);
        }else{
            System.out.println("Nemoguce otkazati pregled manje od dan pred pregled");
        }
        HistoryOfAppointments historyOfAppointments = null;
        List<HistoryOfAppointments> ha = historyOfAppointmentsRepository.findAll();
        for (HistoryOfAppointments h: ha) {
            if(h.getDonator().getId()==donatorId){
                historyOfAppointments = h;
            }
        }
        Report report = new Report(appointment,null,null,historyOfAppointments);
        reportRepository.save(report);


    }

}
