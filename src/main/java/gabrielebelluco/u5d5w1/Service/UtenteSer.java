package gabrielebelluco.u5d5w1.Service;

import gabrielebelluco.u5d5w1.entities.Utente;
import gabrielebelluco.u5d5w1.exceptions.NotFoundException;
import gabrielebelluco.u5d5w1.repositories.UtenteRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteSer {

    private final UtenteRepo utenteRepo;

    public UtenteSer(UtenteRepo utenteRepo) {
        this.utenteRepo = utenteRepo;
    }

    public void save(Utente utente) {
        utenteRepo.save(utente);
    }

    public void addUtente(Utente nUtente) {
        if (utenteRepo.existsByUserName(nUtente.getUserName())) throw new RuntimeException("L'utente già esistente");
        this.utenteRepo.save(nUtente);

    }

    public Utente findById(Long idUtente) {
        return utenteRepo.findById(idUtente).orElseThrow(() -> new NotFoundException(idUtente));

    }

    public List<Utente> getAll() {
        return utenteRepo.findAll();
    }
}
