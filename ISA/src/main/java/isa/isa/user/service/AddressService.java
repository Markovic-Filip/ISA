package isa.isa.user.service;

import isa.isa.user.domain.Address;
import isa.isa.user.domain.City;
import isa.isa.user.domain.Country;


public interface AddressService {

    Address findById(Long id);

    City findByIdCity(Long id);

    Country findByIdCountry(Long id);
}
