package isa.isa.bloodTransfusionCenter.domain;

import isa.isa.bloodTransfusionCenter.domain.enumeration.BloodType;
import isa.isa.user.domain.Address;
import isa.isa.user.domain.Country;

import javax.persistence.*;
import java.util.List;

@Entity
public class Blood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BloodType type;

    @Column
    private Boolean positive;

    @Column
    private int quantity;

    /*@ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Warehouse warehouse;*/


    public Blood(){}

    public Blood(Long id, BloodType type, Boolean positive, int quantity) {
        this.id = id;
        this.type = type;
        this.positive = positive;
        this.quantity = quantity;
    }

    public BloodType getType() {
        return type;
    }

    public void setType(BloodType type) {
        this.type = type;
    }

    public Boolean getPositive() {
        return positive;
    }

    public void setPositive(Boolean positive) {
        this.positive = positive;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
