package isa.isa.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import isa.isa.user.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	List<Role> findByName(String name);
}
