package isa.isa.appointment.domain;

import isa.isa.appointment.domain.enumeration.AppointmentState;
import isa.isa.bloodTransfusionCenter.domain.Warehouse;
import isa.isa.user.domain.CenterAdministrator;
import isa.isa.user.domain.Donator;
import isa.isa.user.domain.User;

import javax.persistence.*;
import java.sql.Time;
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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="donator_id", nullable = false)
    private Donator donator;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="medical_staff_id", nullable = false)
    private CenterAdministrator medicalStaff;
}
