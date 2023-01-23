package isa.isa.appointment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import isa.isa.appointment.domain.enumeration.AppointmentState;
import isa.isa.user.domain.CenterAdministrator;
import isa.isa.user.domain.Donator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private AppointmentState appointmentState;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "appointment")
    private List<Report> report;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "start", column = @Column(name = "appointmentStartTime")),
            @AttributeOverride( name = "end", column = @Column(name = "appointmentEndTime"))
    })
    private TimePeriod timePeriod;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="donator_id")
    private Donator donator;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="medical_staff_id", nullable = false)
    private CenterAdministrator medicalStaff;

    public Appointment(AppointmentState appointmentState, List<Report> report, TimePeriod timePeriod, Donator donator, CenterAdministrator medicalStaff) {
        this.appointmentState = appointmentState;
        this.report = report;
        this.timePeriod = timePeriod;
        this.donator = donator;
        this.medicalStaff = medicalStaff;
    }

    public Appointment() {

    }

    public AppointmentState getAppointmentState() {
        return appointmentState;
    }

    public void setAppointmentState(AppointmentState appointmentState) {
        this.appointmentState = appointmentState;
    }

    public List<Report> getReport() {
        return report;
    }

    public void setReport(List<Report> report) {
        this.report = report;
    }

    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }

    public Donator getDonator() {
        return donator;
    }

    public void setDonator(Donator donator) {
        this.donator = donator;
    }

    public CenterAdministrator getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(CenterAdministrator medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public long getId() {
        return id;
    }
}
