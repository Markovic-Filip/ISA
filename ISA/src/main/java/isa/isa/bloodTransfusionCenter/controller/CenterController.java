package isa.isa.bloodTransfusionCenter.controller;

import isa.isa.bloodTransfusionCenter.domain.Center;
import isa.isa.bloodTransfusionCenter.service.CenterService;
import isa.isa.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class CenterController {

    @Autowired
    private CenterService centerService;

    @GetMapping("/center/all")
    public List<Center> loadAll() {
        return this.centerService.findAll();
    }

}
