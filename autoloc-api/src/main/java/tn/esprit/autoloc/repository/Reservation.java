package tn.esprit.autoloc.repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Reservation extends JpaRepository<tn.esprit.autoloc.domain.Reservation, Long> {
}
