package isa.isa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isa.isa.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);
}

