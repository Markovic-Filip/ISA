package isa.isa.user.domain;

import isa.isa.appointment.domain.Appointment;
import isa.isa.appointment.domain.Report;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class SystemAdministrator extends User{

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "medicalStaff")
    private List<Appointment> appointment;
    public SystemAdministrator(){}
}
