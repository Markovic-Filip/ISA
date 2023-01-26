package isa.isa.appointment.dto;

public class ScheduledAppointment {

    private Long id;
    private String startTime;
    private String endTime;
    private String center;
    private String medicalStaff;

    public ScheduledAppointment(Long id, String startTime, String endTime, String center, String medicalStaff) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.center = center;
        this.medicalStaff = medicalStaff;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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
