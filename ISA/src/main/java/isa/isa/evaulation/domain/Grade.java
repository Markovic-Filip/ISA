package isa.isa.evaulation.domain;

import isa.isa.bloodTransfusionCenter.domain.Center;
import isa.isa.user.domain.Address;
import isa.isa.user.domain.Donator;

import javax.persistence.*;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int grade;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="donator_id", nullable = false)
    private Donator donator;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="center_id", nullable = false)
    private Center center;


    public Grade(){}

    public Grade(int grade, Donator donator, Center center) {
        this.grade = grade;
        this.donator = donator;
        this.center = center;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Donator getDonator() {
        return donator;
    }

    public void setDonator(Donator donator) {
        this.donator = donator;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }
}
