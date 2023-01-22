package isa.isa.user.domain;

import isa.isa.appointment.domain.Appointment;
import isa.isa.appointment.domain.Report;
import isa.isa.user.domain.enumeration.Roles;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value = Roles.Values.SystemAdministrator)
public class SystemAdministrator extends User{

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "medicalStaff")
    private List<Appointment> appointment;
    public SystemAdministrator(){}
}
