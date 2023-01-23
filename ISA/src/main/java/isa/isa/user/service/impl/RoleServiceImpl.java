package isa.isa.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import isa.isa.user.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.isa.user.domain.Role;
import isa.isa.user.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public Role findById(Long id) {
    Role auth = this.roleRepository.getOne(id);
    return auth;
  }

  @Override
  public List<Role> findByName(String name) {
	List<Role> roles = this.roleRepository.findAll();
    List<Role> rolesAuthorities = new ArrayList<>();


    for(Role a : roles){
      if(a.getName().equals(name)){
        rolesAuthorities.add(a);
      }
    }

    return rolesAuthorities;
  }


}
