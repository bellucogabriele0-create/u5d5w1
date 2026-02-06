package gabrielebelluco.u5d5w1.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "utente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long idUtente;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false, unique = true)
    private String email;

    public Utente(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
