package gabrielebelluco.u5d5w1.Service;

import gabrielebelluco.u5d5w1.entities.Utente;
import gabrielebelluco.u5d5w1.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteSer {
    @Autowired
    private UtenteRepo utenteRepo;

    public void save(Utente utente) {
        utenteRepo.save(utente);
    }

    public List<Utente> getAll() {
        return utenteRepo.findAll();
    }
}
