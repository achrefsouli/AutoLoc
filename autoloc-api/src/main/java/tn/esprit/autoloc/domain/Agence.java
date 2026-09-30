package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    @Column(nullable = false, unique = true, length = 10)
    private String nom;
    @Column(nullable = false, unique = true, length = 20)
    private String ville;
    @Column(nullable = false, unique = true, length = 25)
    private String adresse;
    @Column(nullable = false, unique = true, length = 8)
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "agence")
    private Set<Vehicule> vehicules;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "agence")
    private Set<Employe> employes;
}
