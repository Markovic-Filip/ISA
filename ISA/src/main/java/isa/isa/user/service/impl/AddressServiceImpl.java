package isa.isa.user.service.impl;

import isa.isa.user.dto.AddressDTO;
import isa.isa.user.mapper.AddressMapper;
import isa.isa.user.repository.AddressRepository;
import isa.isa.user.service.AddressService;
import isa.isa.user.domain.Address;
import isa.isa.user.domain.City;
import isa.isa.user.domain.Country;
import isa.isa.user.repository.CityRepository;
import isa.isa.user.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Address findById(Long id) {
        Address address = this.addressRepository.getOne(id);
        return address;
    }

    @Override
    public City findByIdCity(Long id) {
        City city = this.cityRepository.getOne(id);
        return city;
    }

    @Override
    public Country findByIdCountry(Long id) {
        Country country = this.countryRepository.getOne(id);
        return country;
    }

    @Override
    public List<AddressDTO> findAll() {
        List<AddressDTO> addressDTOS = new ArrayList<AddressDTO>();
        List<Address> addresses = addressRepository.findAll();
        for (Address a : addresses) {
            addressDTOS.add(AddressMapper.addressToAddressDTO(a));
        }

        return addressDTOS;
    }
}
