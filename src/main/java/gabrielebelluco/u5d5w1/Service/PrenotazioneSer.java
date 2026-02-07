package gabrielebelluco.u5d5w1.Service;

import gabrielebelluco.u5d5w1.entities.Postazione;
import gabrielebelluco.u5d5w1.entities.Prenotazione;
import gabrielebelluco.u5d5w1.entities.Utente;
import gabrielebelluco.u5d5w1.exceptions.NotFoundException;
import gabrielebelluco.u5d5w1.repositories.PrenotazioneRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneSer {

    private final PrenotazioneRepo prenotazioneRepo;
    private final PostazioneSer postazioneSer;
    private final UtenteSer utenteSer;

    public PrenotazioneSer(PrenotazioneRepo prenotazioneRepo, PostazioneSer postazioneSer, UtenteSer utenteSer) {
        this.prenotazioneRepo = prenotazioneRepo;
        this.postazioneSer = postazioneSer;
        this.utenteSer = utenteSer;
    }

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

    public void addPrenotazione(Long idUtente, Long idPostazione, LocalDate date) {
        Utente utenteFromDB = utenteSer.findById(idUtente);
        Postazione postazioneFromDB = postazioneSer.findById(idPostazione);
        if (utenteFromDB == null) throw new NotFoundException(idUtente);
        if (postazioneFromDB == null) throw new NotFoundException(idPostazione);

        boolean occupata = prenotazioneRepo.existsBydataPrenotazioneAndIdPostazionefk(date, postazioneFromDB);
        if (occupata) throw new RuntimeException("£postazione occupata");
        Prenotazione nprenotazione = new Prenotazione(date, utenteFromDB, postazioneFromDB);
        prenotazioneRepo.save(nprenotazione);
        System.out.println("stampa nuova postazione " + nprenotazione);


    }

    public List<Prenotazione> findByUtente(Utente utente) {
        return prenotazioneRepo.findByIdUtentefk(utente);
    }

}
