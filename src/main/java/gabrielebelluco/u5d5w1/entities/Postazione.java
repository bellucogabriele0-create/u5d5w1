package gabrielebelluco.u5d5w1.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "postazione")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long idPostazione;
    @Column(nullable = false, unique = true)
    private String codicePostazione;
    @Column(nullable = false)
    private String descrizionePostazione;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPostazione tipoPostazione;
    @Column(nullable = false)
    private int numMaxOccupanti;

    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Edificio idEdificiofk;
}
