package isa.isa.user.repository;

import isa.isa.user.domain.Donator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonatorRepository extends JpaRepository<Donator,Long> {
}
