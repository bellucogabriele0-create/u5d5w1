package gabrielebelluco.u5d5w1.Service;

import gabrielebelluco.u5d5w1.entities.Prenotazione;
import gabrielebelluco.u5d5w1.repositories.PrenotazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneSer {
    @Autowired
    private PrenotazioneRepo prenotazioneRepo;

    public void save(Prenotazione prenotazione) {
        prenotazioneRepo.save(prenotazione);
    }

    public List<Prenotazione> getAll() {
        return prenotazioneRepo.findAll();
    }

}
