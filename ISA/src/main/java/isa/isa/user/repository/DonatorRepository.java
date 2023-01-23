package isa.isa.user.repository;

import isa.isa.user.domain.Donator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DonatorRepository extends JpaRepository<Donator,Long> {
    Donator getDonatorByUsername(String username);

    @Query("SELECT u FROM Donator u WHERE u.verificationCode = ?1")
    public Donator findByVerificationCode(String code);
}
