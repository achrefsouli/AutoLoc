package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    @Column(nullable = false, unique = true)
    private LocalDate dateDebut;
    @Column(nullable = false, unique = true)
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private statutReservation statut;
    @OneToOne
    private Contrat contrat;
    @ManyToOne
    Client client;
    @ManyToOne
    Vehicule vehicule;
}
