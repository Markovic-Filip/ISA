package isa.isa.bloodTransfusionCenter.dto;

import isa.isa.user.dto.AddressDTO;

public class CenterDTO {


    private String description;
    private String name;

    private String address;
    private Double averageGrade;



    public CenterDTO(String description, String name, String addressDTO, Double averageGrade) {
        this.description = description;
        this.name = name;
        this.address = addressDTO;
        this.averageGrade = averageGrade;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressDTO() {
        return address;
    }

    public void setAddressDTO(String addressDTO) {
        this.address = addressDTO;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }
}
