package isa.isa.user.domain;

import isa.isa.bloodTransfusionCenter.domain.Center;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CenterAdministrator extends User{

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="center", nullable = false)
    private Center center;

    public CenterAdministrator() {}
}
