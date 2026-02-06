package gabrielebelluco.u5d5w1.repositories;

import gabrielebelluco.u5d5w1.entities.Postazione;
import gabrielebelluco.u5d5w1.entities.Prenotazione;
import gabrielebelluco.u5d5w1.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {

    boolean existsByIdUtentefkAndDataPrenotazione(Utente utente, LocalDate data);

    boolean existsByIdPostazionefkAndDataPrenotazione(Postazione postazione, LocalDate data);

    List<Prenotazione> findByIdUtentefk(Utente utente);
}
