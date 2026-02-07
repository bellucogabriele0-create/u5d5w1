package gabrielebelluco.u5d5w1.Service;

import gabrielebelluco.u5d5w1.entities.Edificio;
import gabrielebelluco.u5d5w1.entities.Postazione;
import gabrielebelluco.u5d5w1.entities.TipoPostazione;
import gabrielebelluco.u5d5w1.repositories.PostazioneRepo;
import gabrielebelluco.u5d5w1.repositories.PrenotazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneSer {
    private final PrenotazioneRepo prenotazioneRepo;
    @Autowired
    private PostazioneRepo postazioneRepo;
    private EdificioSer edificioSer;

    public PostazioneSer(PostazioneRepo postazioneRepo, EdificioSer edificioSer, PrenotazioneRepo prenotazioneRepo) {
        this.postazioneRepo = postazioneRepo;
        this.edificioSer = edificioSer;
        this.prenotazioneRepo = prenotazioneRepo;
    }

    public void addPostazione(String codicePostazione, long idEdificio, TipoPostazione tipoPostazione, String descrizione, int numMaxOccupanti) {
        Edificio edificioFromDb = this.edificioSer.findById(idEdificio);
        if (edificioFromDb == null)
            throw new RuntimeException("non esiste l'edificio con id: " + idEdificio);
        Postazione nPostazione = new Postazione(codicePostazione, descrizione, tipoPostazione, numMaxOccupanti, edificioFromDb);

        this.postazioneRepo.save(nPostazione);
        System.out.println("postazione salvata con id: " + nPostazione.getIdPostazione());

    }

    public void save(Postazione postazione) {
        postazioneRepo.save(postazione);
    }

    public List<Postazione> getAll() {
        return postazioneRepo.findAll();
    }


    public List<Postazione> findByTipo(TipoPostazione tipoPostazione) {
        return postazioneRepo.findByTipoPostazione(tipoPostazione);
    }

    public Postazione findById(long id) {
        return postazioneRepo.findById(id).orElseThrow(() -> new RuntimeException(" non trovato"));
    }

    public List<Postazione> findByCitta(String citta) {
        return postazioneRepo.findByIdEdificiofk_CittaEdificio(citta);
    }


}
