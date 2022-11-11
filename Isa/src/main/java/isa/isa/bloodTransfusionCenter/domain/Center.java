package isa.isa.bloodTransfusionCenter.domain;

import isa.isa.appointment.domain.TimePeriod;
import isa.isa.evaulation.domain.Grade;
import isa.isa.user.domain.Address;
import isa.isa.user.domain.CenterAdministrator;
import isa.isa.user.domain.SystemAdministrator;
import isa.isa.user.domain.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    //workshift

    @OneToOne(targetEntity=Address.class,fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Address address;

    @OneToOne(targetEntity=Warehouse.class,fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Warehouse warehouse;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "center")
    private List<CenterAdministrator> centerAdministrators;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "center")
    private List<Grade> grade;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="center_id",referencedColumnName = "id",nullable = false)
    private List<WorkShift> workShift = new ArrayList<WorkShift>();

    public Center(){}



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<CenterAdministrator> getCenterAdministrators() {
        return centerAdministrators;
    }

    public void setCenterAdministrators(List<CenterAdministrator> centerAdministrators) {
        this.centerAdministrators = centerAdministrators;
    }

    public List<Grade> getGrade() {
        return grade;
    }

    public void setGrade(List<Grade> grade) {
        this.grade = grade;
    }

    public List<WorkShift> getWorkShift() {
        return workShift;
    }

    public void setWorkShift(List<WorkShift> workShift) {
        this.workShift = workShift;
    }
}

