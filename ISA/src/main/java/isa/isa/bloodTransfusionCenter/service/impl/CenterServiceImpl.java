package isa.isa.bloodTransfusionCenter.service.impl;

import isa.isa.bloodTransfusionCenter.domain.Center;
import isa.isa.bloodTransfusionCenter.repository.CenterRepository;
import isa.isa.bloodTransfusionCenter.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterServiceImpl implements CenterService {

    @Autowired
    private CenterRepository centerRepository;
    @Override
    public List<Center> findAll() {
        return this.centerRepository.findAll();
    }
}
