package isa.isa.user.service;

import isa.isa.user.domain.Address;
import isa.isa.user.domain.City;
import isa.isa.user.domain.Country;
import isa.isa.user.dto.AddressDTO;

import java.util.List;


public interface AddressService {

    Address findById(Long id);

    City findByIdCity(Long id);

    Country findByIdCountry(Long id);

    List<AddressDTO> findAll();
}
