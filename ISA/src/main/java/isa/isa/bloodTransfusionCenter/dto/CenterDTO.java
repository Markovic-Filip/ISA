package isa.isa.bloodTransfusionCenter.dto;

import isa.isa.user.dto.AddressDTO;

public class CenterDTO {


    private String description;
    private String name;

    private AddressDTO addressDTO;



    public CenterDTO(String description, String name, AddressDTO addressDTO) {
        this.description = description;
        this.name = name;
        this.addressDTO = addressDTO;
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

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}
