package isa.isa.donator.dto;

import java.util.Date;

public class HistorySuccessfulDTO {

    private Date startTime;
    private Date endTime;
    private String center;
    private String medicalStaff;

    public HistorySuccessfulDTO(){};

    public HistorySuccessfulDTO(Date startTime, Date endTime, String center, String medicalStaff) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.center = center;
        this.medicalStaff = medicalStaff;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(String medicalStaff) {
        this.medicalStaff = medicalStaff;
    }
}
