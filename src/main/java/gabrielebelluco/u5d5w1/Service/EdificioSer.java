package gabrielebelluco.u5d5w1.Service;

import gabrielebelluco.u5d5w1.entities.Edificio;
import gabrielebelluco.u5d5w1.repositories.EdificioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioSer {
    @Autowired
    private EdificioRepo edificioRepo;

    public void save(Edificio edificio) {
        edificioRepo.save(edificio);
    }

    public List<Edificio> getAll() {
        return edificioRepo.findAll();
    }
}
