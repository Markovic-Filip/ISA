package isa.isa.user.service;

import java.util.List;

import isa.isa.user.domain.Role;

public interface RoleService {
	Role findById(Long id);
	List<Role> findByName(String name);
}
