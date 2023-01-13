package isa.isa.bloodTransfusionCenter.controller;

import isa.isa.bloodTransfusionCenter.domain.Center;
import isa.isa.bloodTransfusionCenter.dto.CenterDTO;
import isa.isa.bloodTransfusionCenter.mapper.CenterMapper;
import isa.isa.bloodTransfusionCenter.service.CenterService;
import isa.isa.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:8090")
@RestController
@RequestMapping(value = "/center", produces = MediaType.APPLICATION_JSON_VALUE)
public class CenterController {



    @Autowired
    private CenterService centerService;

    @GetMapping("/all")
    public ResponseEntity<?> loadAll() {
        List<Center> centers = this.centerService.findAll();
        List<CenterDTO> centerDTOS = CenterMapper.mapCenterToCenterDTO(centers);

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

}
