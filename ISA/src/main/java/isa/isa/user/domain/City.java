package isa.isa.user.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String zipCode;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="country_id", nullable = false)
    private Country country;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "city")
    private List<Address> address;

    public City(){};

    public City(Long id, String name, String zipCode/*, Country country*/) {
        this.id = id;
        this.name = name;
        this.zipCode = zipCode;
        //this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
/*
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }*/


}
