package isa.isa.bloodTransfusionCenter.domain;

import isa.isa.appointment.domain.TimePeriod;

import javax.persistence.*;

@Entity
public class WorkShift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "start", column = @Column(name = "StartTime")),
            @AttributeOverride( name = "end", column = @Column(name = "EndTime"))
    })
    private TimePeriod timePeriod;

    public WorkShift(){}

    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }
}
