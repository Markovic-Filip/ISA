package isa.isa.user.service;

import java.util.List;

import isa.isa.user.domain.Donator;
import isa.isa.user.dto.UserRequest;
import isa.isa.user.domain.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    User findByEmail(String email) throws UsernameNotFoundException;

    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
	User save(UserRequest userRequest);

    int penaltys(Long id);
}
