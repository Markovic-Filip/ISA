package isa.isa.donator.repository;

import isa.isa.donator.domain.HistoryOfAppointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryOfAppointmentsRepository extends JpaRepository<HistoryOfAppointments, Long> {
}
