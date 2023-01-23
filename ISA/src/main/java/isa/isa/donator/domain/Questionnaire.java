package isa.isa.donator.domain;

import isa.isa.user.domain.Donator;

import javax.persistence.*;

@Entity
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(targetEntity= Donator.class,fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Donator donator;
    //pitanja razna idk

    public Questionnaire(){}

    public Donator getDonator() {
        return donator;
    }

    public void setDonator(Donator donator) {
        this.donator = donator;
    }
}
