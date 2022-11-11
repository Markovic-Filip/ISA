package isa.isa.appointment.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
public class TimePeriod {

    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    //Appointment
    //Center
    public TimePeriod(){}

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
