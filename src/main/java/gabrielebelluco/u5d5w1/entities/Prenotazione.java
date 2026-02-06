package gabrielebelluco.u5d5w1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazione")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long idPrenotazione;
    @Column(nullable = false)
    private LocalDate dataPrenotazione;
    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente idUtentefk;
    @ManyToOne
    @JoinColumn(name = "id_postazione")
    private Postazione idPostazionefk;

}
