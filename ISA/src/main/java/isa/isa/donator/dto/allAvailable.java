package isa.isa.donator.dto;

public class AllAvailable {
    private Long centerId;
    private String username;

    public AllAvailable(){};

    public AllAvailable(Long centerId, String username) {
        this.centerId = centerId;
        this.username = username;
    }

    public Long getCenterId() {
        return centerId;
    }

    public void setCenterId(Long centerId) {
        this.centerId = centerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
