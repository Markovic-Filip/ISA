package isa.isa.user.domain;

import isa.isa.user.domain.enumeration.Gender;
import isa.isa.user.domain.enumeration.Role;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String phoneNumber;

    @Column
    private String jmbg;

    @Column
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="address", nullable = false)
    private Address address;

    @Column
    private String profession;

    @Column
    private String company;

    @Column
    private Boolean activated;

    @Column
    private Boolean passwordChanged;

    @Column
    private Role role;

    public User(){}

    public User(Long id, String name, String surname, String email, String password, String phoneNumber, String jmbg, Gender gender, Address address, String profession, String company, Boolean activated, Boolean passwordChanged, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.jmbg = jmbg;
        this.gender = gender;
        this.address = address;
        this.profession = profession;
        this.company = company;
        this.activated = activated;
        this.passwordChanged = passwordChanged;
        this.role = role;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }



    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Boolean getPasswordChanged() {
        return passwordChanged;
    }

    public void setPasswordChanged(Boolean passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
