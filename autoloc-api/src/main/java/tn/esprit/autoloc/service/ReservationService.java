package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final tn.esprit.autoloc.repository.Reservation reservationRepository;
    public ReservationService(tn.esprit.autoloc.repository.Reservation reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    public Reservation saveReservation(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }
    public List<Reservation> findAllReservations() {
        return this.reservationRepository.findAll();
    }
    public Optional<Reservation> findReservationById(Long idReservation) {
        return this.reservationRepository.findById(idReservation);
    }
    public Reservation updateReservation(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }
    public void deleteReservationById(Long idReservation) {
        this.reservationRepository.deleteById(idReservation);
    }
    public boolean existsReservationById(Long idReservation) {
        return this.reservationRepository.existsById(idReservation);
    }
}
