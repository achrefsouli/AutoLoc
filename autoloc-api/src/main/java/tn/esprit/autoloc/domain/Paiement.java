package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "paiment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;
    @Column(nullable = false, unique = true)
    private LocalDate datePaiement;
    @Column(nullable = false, unique = true)
    private BigDecimal montant;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private modePaiement modePaiement;
    @ManyToOne(cascade = CascadeType.ALL)
    Contrat contrat;
}
