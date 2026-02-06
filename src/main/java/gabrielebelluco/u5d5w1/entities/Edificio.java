package gabrielebelluco.u5d5w1.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "edificio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long idEdificio;
    @Column(nullable = false)
    private String nomeEdificio;
    @Column(nullable = false)
    private String indirizzoEdificio;
    @Column(nullable = false)
    private String cittaEdificio;

}
