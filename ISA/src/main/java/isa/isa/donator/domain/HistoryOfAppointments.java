package isa.isa.donator.domain;

import isa.isa.appointment.domain.Report;
import isa.isa.bloodTransfusionCenter.domain.Equipment;
import isa.isa.user.domain.Address;
import isa.isa.user.domain.Donator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HistoryOfAppointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(targetEntity= Donator.class,fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Donator donator;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="history_id",referencedColumnName = "id",nullable = false)
    private List<Report> report = new ArrayList<Report>();

    public HistoryOfAppointments(){}

    public HistoryOfAppointments(Donator donator, List<Report> report) {
        this.donator = donator;
        this.report = report;
    }

    public Donator getDonator() {
        return donator;
    }

    public void setDonator(Donator donator) {
        this.donator = donator;
    }

    public List<Report> getReport() {
        return report;
    }

    public void setReport(List<Report> report) {
        this.report = report;
    }
}
