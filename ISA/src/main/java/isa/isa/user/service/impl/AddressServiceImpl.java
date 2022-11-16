package isa.isa.user.service.impl;

import isa.isa.user.domain.Address;
import isa.isa.user.repository.AddressRepository;
import isa.isa.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address findById(Long id) {
        Address address = this.addressRepository.getOne(id);
        return address;
    }
}
