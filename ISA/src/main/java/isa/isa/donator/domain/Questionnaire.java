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

    @Column
    private Boolean q1;

    @Column
    private Boolean q2;

    @Column
    private Boolean q3;

    @Column
    private Boolean q4;

    @Column
    private Boolean q5;

    @Column
    private Boolean q6;

    @Column
    private Boolean q7;

    @Column
    private Boolean q8;

    @Column
    private Boolean q9;

    @Column
    private Boolean q10;

    @Column
    private Boolean q11;

    @Column
    private Boolean q12;

    @Column
    private Boolean filled;


    public Questionnaire(){}

    public Donator getDonator() {
        return donator;
    }

    public void setDonator(Donator donator) {
        this.donator = donator;
    }

    public Boolean getQ1() {
        return q1;
    }

    public void setQ1(Boolean q1) {
        this.q1 = q1;
    }

    public Boolean getQ2() {
        return q2;
    }

    public void setQ2(Boolean q2) {
        this.q2 = q2;
    }

    public Boolean getQ3() {
        return q3;
    }

    public void setQ3(Boolean q3) {
        this.q3 = q3;
    }

    public Boolean getQ4() {
        return q4;
    }

    public void setQ4(Boolean q4) {
        this.q4 = q4;
    }

    public Boolean getQ5() {
        return q5;
    }

    public void setQ5(Boolean q5) {
        this.q5 = q5;
    }

    public Boolean getQ6() {
        return q6;
    }

    public void setQ6(Boolean q6) {
        this.q6 = q6;
    }

    public Boolean getQ7() {
        return q7;
    }

    public void setQ7(Boolean q7) {
        this.q7 = q7;
    }

    public Boolean getQ8() {
        return q8;
    }

    public void setQ8(Boolean q8) {
        this.q8 = q8;
    }

    public Boolean getQ9() {
        return q9;
    }

    public void setQ9(Boolean q9) {
        this.q9 = q9;
    }

    public Boolean getQ10() {
        return q10;
    }

    public void setQ10(Boolean q10) {
        this.q10 = q10;
    }

    public Boolean getQ11() {
        return q11;
    }

    public void setQ11(Boolean q11) {
        this.q11 = q11;
    }

    public Boolean getQ12() {
        return q12;
    }

    public void setQ12(Boolean q12) {
        this.q12 = q12;
    }

    public Boolean getFilled() {
        return filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    public long getId() {
        return id;
    }
}
