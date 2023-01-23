package isa.isa.user.mapper;

import isa.isa.user.dto.AddressDTO;
import isa.isa.user.service.AddressService;
import isa.isa.user.domain.Address;
import isa.isa.user.domain.City;
import isa.isa.user.domain.Country;

public class AddressMapper {

    private static AddressService addressService;

    public static AddressDTO addressToAddressDTO(Address address){
        Address a = address;
        City ci = a.getCity();
        Country co = ci.getCountry();

        AddressDTO addressDTO = new AddressDTO(a.getNumber(), a.getStreet(), ci.getName(), ci.getZipCode(), co.getName());



        return addressDTO;
    }
}
