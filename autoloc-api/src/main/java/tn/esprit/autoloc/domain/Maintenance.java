package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "equipement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;
    @Column(nullable = false, unique = true, length = 50)
    private String description;
    @Column(nullable = false, unique = true)
    private LocalDate dateDebut;
    @Column(nullable = false, unique = true)
    private LocalDate dateFin;
    @ManyToOne(cascade = CascadeType.ALL)
    Vehicule vehicule;
}
