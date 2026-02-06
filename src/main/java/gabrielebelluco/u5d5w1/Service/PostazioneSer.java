package gabrielebelluco.u5d5w1.Service;

import gabrielebelluco.u5d5w1.entities.Postazione;
import gabrielebelluco.u5d5w1.repositories.PostazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneSer {
    @Autowired
    private PostazioneRepo postazioneRepo;

    public void save(Postazione postazione) {
        postazioneRepo.save(postazione);
    }

    public List<Postazione> getAll() {
        return postazioneRepo.findAll();
    }
}
