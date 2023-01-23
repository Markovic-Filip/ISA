package isa.isa.user.domain;

import isa.isa.bloodTransfusionCenter.domain.Center;
import isa.isa.user.domain.enumeration.Roles;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = Roles.Values.CenterAdministrator)
public class CenterAdministrator extends User{

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="center", nullable = false)
    private Center center;

    public CenterAdministrator() {}

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }
}
