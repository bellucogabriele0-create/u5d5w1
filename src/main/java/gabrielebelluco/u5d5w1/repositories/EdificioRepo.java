package gabrielebelluco.u5d5w1.repositories;

import gabrielebelluco.u5d5w1.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EdificioRepo extends JpaRepository<Edificio, Long> {
}
