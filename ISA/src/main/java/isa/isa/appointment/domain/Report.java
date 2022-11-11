package isa.isa.appointment.domain;

import isa.isa.bloodTransfusionCenter.domain.Blood;
import isa.isa.bloodTransfusionCenter.domain.Equipment;
import isa.isa.user.domain.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Report {
    @Column(name="report_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="appointment_id", nullable = false)
    private Appointment appointment;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="blood_id", nullable = false)
    private Blood blood;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Report_Equipment",
            joinColumns = { @JoinColumn(name = "report_id") },
            inverseJoinColumns = { @JoinColumn(name = "equipment_id") }
    )
    List<Equipment> equipment = new ArrayList<>();
    //jos par sranja da li je uspesan ne i tako
}
