package gabrielebelluco.u5d5w1.repositories;

import gabrielebelluco.u5d5w1.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UtenteRepo extends JpaRepository<Utente, Long> {
    boolean existsByUserName(String userName);
}
