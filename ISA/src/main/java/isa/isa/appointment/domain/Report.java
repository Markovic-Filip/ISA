package isa.isa.appointment.domain;

import isa.isa.bloodTransfusionCenter.domain.Blood;
import isa.isa.bloodTransfusionCenter.domain.Equipment;
import isa.isa.donator.domain.HistoryOfAppointments;

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
    @JoinColumn(name="history_id", nullable = false)
    private HistoryOfAppointments historyOfAppointments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="blood_id")
    private Blood blood;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Report_Equipment",
            joinColumns = { @JoinColumn(name = "report_id") },
            inverseJoinColumns = { @JoinColumn(name = "equipment_id") }
    )
    List<Equipment> equipment = new ArrayList<>();

    public Report() {

    }
    //jos par sranja da li je uspesan ne i tako


    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Blood getBlood() {
        return blood;
    }

    public void setBlood(Blood blood) {
        this.blood = blood;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public HistoryOfAppointments getHistoryOfAppointments() {
        return historyOfAppointments;
    }

    public void setHistoryOfAppointments(HistoryOfAppointments historyOfAppointments) {
        this.historyOfAppointments = historyOfAppointments;
    }

    public Report(Appointment appointment, Blood blood, List<Equipment> equipment, HistoryOfAppointments historyOfAppointments) {
        this.appointment = appointment;
        this.blood = blood;
        this.equipment = equipment;
        this.historyOfAppointments = historyOfAppointments;
    }
}
