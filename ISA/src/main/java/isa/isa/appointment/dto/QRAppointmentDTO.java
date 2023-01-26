package isa.isa.appointment.dto;

import java.util.Date;

public class QRAppointmentDTO {
    private String startTime;
    private String qrCodePath;

    public QRAppointmentDTO(){};

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public QRAppointmentDTO(String startTime, String qrCodePath) {
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
