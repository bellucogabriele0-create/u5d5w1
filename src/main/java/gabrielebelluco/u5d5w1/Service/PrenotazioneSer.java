package gabrielebelluco.u5d5w1.Service;

import gabrielebelluco.u5d5w1.entities.Prenotazione;
import gabrielebelluco.u5d5w1.entities.Utente;
import gabrielebelluco.u5d5w1.repositories.PrenotazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneSer {
    @Autowired
    private PrenotazioneRepo prenotazioneRepo;

    public void save(Prenotazione prenotazione) {
        if (prenotazioneRepo.existsByIdUtentefkAndDataPrenotazione(prenotazione.getIdUtentefk(), prenotazione.getDataPrenotazione())) {
            throw new RuntimeException("ha già prenotato");
        }

        if (prenotazioneRepo.existsByIdPostazionefkAndDataPrenotazione(prenotazione.getIdPostazionefk(),
                prenotazione.getDataPrenotazione())) {
            throw new RuntimeException("data gia prenotata");
        }
        prenotazioneRepo.save(prenotazione);
    }

    public List<Prenotazione> getAll() {
        return prenotazioneRepo.findAll();
    }

    public List<Prenotazione> findByUtente(Utente utente) {
        return prenotazioneRepo.findByIdUtentefk(utente);
    }
}
