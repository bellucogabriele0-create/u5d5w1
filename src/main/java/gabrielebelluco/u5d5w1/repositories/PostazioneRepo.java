package gabrielebelluco.u5d5w1.repositories;

import gabrielebelluco.u5d5w1.entities.Postazione;
import gabrielebelluco.u5d5w1.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PostazioneRepo extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoPostazione(TipoPostazione tipoPostazione);

    List<Postazione> findByIdEdificiofk_CittaEdificio(String citta);
}
