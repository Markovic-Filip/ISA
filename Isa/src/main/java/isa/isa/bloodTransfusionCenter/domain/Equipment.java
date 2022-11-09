package isa.isa.bloodTransfusionCenter.domain;

import isa.isa.user.domain.Address;
import isa.isa.user.domain.Country;


import javax.persistence.*;
import java.util.List;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int quantity;

    @Column
    private String name;

    /*@ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Warehouse warehouse;*/


    public Equipment(){}

    public Equipment(Long id, int quantity, String name) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
