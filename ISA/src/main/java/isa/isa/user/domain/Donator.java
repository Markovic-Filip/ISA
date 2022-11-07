package isa.isa.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Donator extends User{

    @Column
    private int penaltys;

    public Donator() {
    }

    public int getPenaltys() {
        return penaltys;
    }

    public void setPenaltys(int penaltys) {
        this.penaltys = penaltys;
    }
}
