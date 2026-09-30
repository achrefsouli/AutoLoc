package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;
    @Column(nullable = false, unique = true, length = 10)
    private String nom;
    @Column(nullable = false, unique = true, length = 10)
    private String prenom;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private role role;
    @ManyToOne
    Agence agence;


}
