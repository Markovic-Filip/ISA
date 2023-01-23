package isa.isa.bloodTransfusionCenter.repository;

import isa.isa.bloodTransfusionCenter.domain.Blood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodRepository extends JpaRepository<Blood,Long> {
}
