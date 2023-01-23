package isa.isa.appointment.dto;

import java.util.Date;

public class QRAppointmentDTO {
    private Date startTime;
    private String qrCodePath;

    public QRAppointmentDTO(){};

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public QRAppointmentDTO(Date startTime, String qrCodePath) {
        this.startTime = startTime;
        this.qrCodePath = qrCodePath;
    }

    public String getQrCodePath() {
        return qrCodePath;
    }

    public void setQrCodePath(String qrCodePath) {
        this.qrCodePath = qrCodePath;
    }
}
