package isa.isa.bloodTransfusionCenter.domain;

import isa.isa.user.domain.Address;

import javax.persistence.*;

@Entity
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    //TimePeriod
    @OneToOne(targetEntity=Address.class,fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Address address;
    @OneToOne(targetEntity=Warehouse.class,fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Warehouse warehouse;

    public Center(){}

}

