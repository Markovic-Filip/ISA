package isa.isa.bloodTransfusionCenter.domain;

import isa.isa.user.domain.Address;
import isa.isa.user.domain.Country;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="warehouse_id",referencedColumnName = "id",nullable = false)
    private List<Blood> blood = new ArrayList<Blood>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="warehouse_id",referencedColumnName = "id",nullable = false)
    private List<Equipment> equipment = new ArrayList<Equipment>();

    @OneToOne(targetEntity = Center.class)
    private Center center;



    public Warehouse(){}

    public Warehouse(List<Blood> blood, List<Equipment> equipment) {
        this.blood = blood;
        this.equipment = equipment;
    }

    public List<Blood> getBlood() {
        return blood;
    }

    public void setBlood(List<Blood> blood) {
        this.blood = blood;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }
}
