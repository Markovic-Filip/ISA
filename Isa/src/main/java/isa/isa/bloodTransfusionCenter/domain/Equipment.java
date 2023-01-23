package isa.isa.bloodTransfusionCenter.domain;

import isa.isa.appointment.domain.Report;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipment {
    @Column(name="equipment_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int quantity;

    @Column
    private String name;

    @ManyToMany(mappedBy = "equipment")
    private List<Report> report = new ArrayList<>();


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
