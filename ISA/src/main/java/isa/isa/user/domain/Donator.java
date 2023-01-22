package isa.isa.user.domain;

import isa.isa.appointment.domain.Appointment;
import isa.isa.appointment.domain.Report;
import isa.isa.donator.domain.HistoryOfAppointments;
import isa.isa.donator.domain.Questionnaire;
import isa.isa.evaulation.domain.Grade;
import isa.isa.user.domain.enumeration.Roles;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value = Roles.Values.Donator)
public class Donator extends User{

    @Column
    private int penaltys;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "donator")
    private List<Grade> grade;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "donator")
    private List<Appointment> appointment;

    @OneToOne(targetEntity = Questionnaire.class)
    private Questionnaire questionnaire;

    @OneToOne(targetEntity=HistoryOfAppointments.class)
    private HistoryOfAppointments historyOfAppointments;

    public Donator() {
    }

    public int getPenaltys() {
        return penaltys;
    }

    public void setPenaltys(int penaltys) {
        this.penaltys = penaltys;
    }
}
