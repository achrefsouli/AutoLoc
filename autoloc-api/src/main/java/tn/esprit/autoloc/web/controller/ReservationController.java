package tn.esprit.autoloc.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
    private final ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }
    @GetMapping("/getAll")
    public List<Reservation> getAllReservations() {
        return reservationService.findAllReservations();
    }
    @GetMapping("/get/{idReservation}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long idReservation) {
        return reservationService.findReservationById(idReservation)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{idReservation}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long idReservation, @RequestBody Reservation reservation) {
        if (!reservationService.existsReservationById(idReservation)) {
            return ResponseEntity.notFound().build();
        }
        reservation.setIdReservation(idReservation);
        return ResponseEntity.ok(reservationService.updateReservation(reservation));
    }
    @DeleteMapping("/delete/{idReservation}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long idReservation) {
        if (!reservationService.existsReservationById(idReservation)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        reservationService.deleteReservationById(idReservation);
        return ResponseEntity.noContent().build();
    }
}
