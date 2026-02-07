package gabrielebelluco.u5d5w1.Service;

import gabrielebelluco.u5d5w1.entities.Edificio;
import gabrielebelluco.u5d5w1.exceptions.NotFoundException;
import gabrielebelluco.u5d5w1.repositories.EdificioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioSer {
    private final EdificioRepo edificioRepo;

    @Autowired
    public EdificioSer(EdificioRepo edificioRepo) {
        this.edificioRepo = edificioRepo;
    }

    public void aggiuntaEdificio(Edificio nEdificio) {
        if (edificioRepo.existsByNomeEdificio(nEdificio.getNomeEdificio()))
            throw new RuntimeException("hai già creato :" + nEdificio.getNomeEdificio());
        this.edificioRepo.save(nEdificio);
        System.out.println("l'edificio è stato creato con: " + nEdificio.getIdEdificio());

    }

    public Edificio findById(long idEdificio) {
        return edificioRepo.findById(idEdificio).orElseThrow(() -> new NotFoundException(idEdificio));

    }

}
