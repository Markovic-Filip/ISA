package isa.isa.user.domain;

import isa.isa.bloodTransfusionCenter.domain.Center;

import javax.persistence.*;
import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String street;

    @Column
    private String number;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="city_id", nullable = false)
    private City city;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "address")
    private List<User> user;

    @OneToOne(targetEntity=Center.class)
    private Center center;

    public Address(){}

    public Address(Long id, String street, String number/*, City city*/) {
        this.id = id;
        this.street = street;
        this.number = number;
        //this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }
}
