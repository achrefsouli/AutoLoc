package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    @Column(nullable = false, unique = true, length = 10)
    private String nom;
    @Column(nullable = false, unique = true, length = 10)
    private String prenom;
    @Column(nullable = false, unique = true, length = 25)
    private String email;
    @Column(nullable = false, unique = true, length = 25)
    private String telephone;
    @Column(nullable = false, unique = true, length = 8)
    private String numPermis;
    @Column(nullable = false, unique = true)
    private LocalDate dateInscription;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Reservation> reservations;


}
