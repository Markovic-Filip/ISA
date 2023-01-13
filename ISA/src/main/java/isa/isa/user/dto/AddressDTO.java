package isa.isa.user.dto;

public class AddressDTO {

    private String number;

    private String street;

    private String cityName;

    private String zipCode;

    private String countryName;

    public AddressDTO(){};

    public AddressDTO(String number, String street, String cityName, String zipCode, String countryName) {
        this.number = number;
        this.street = street;
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.countryName = countryName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
