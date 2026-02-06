package gabrielebelluco.u5d5w1;

import com.github.javafaker.Faker;
import gabrielebelluco.u5d5w1.Service.EdificioSer;
import gabrielebelluco.u5d5w1.Service.PostazioneSer;
import gabrielebelluco.u5d5w1.Service.PrenotazioneSer;
import gabrielebelluco.u5d5w1.Service.UtenteSer;
import gabrielebelluco.u5d5w1.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Locale;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private EdificioSer edificioSer;
    @Autowired
    private PostazioneSer postazioneSer;
    @Autowired
    private UtenteSer utenteSer;
    @Autowired
    private PrenotazioneSer prenotazioneSer;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.ITALY);
        Edificio RenzoPianoBuilding = new Edificio("sede di cagliari", faker.address().streetAddress(), "Cagliari");
        Edificio CucinellaArchitects = new Edificio("sede di berlino", faker.address().streetAddress(), "Berlino");
        Edificio BoeriArchitetti = new Edificio("sede di oklahoma", faker.address().streetAddress(), "Oklahoma");

        edificioSer.save(RenzoPianoBuilding);
        edificioSer.save(CucinellaArchitects);
        edificioSer.save(BoeriArchitetti);
        Utente Utente1 = new Utente("Renzo Piano", faker.internet().emailAddress());
        Utente Utente2 = new Utente("Mario Cucinella", faker.internet().emailAddress());
        Utente Utente3 = new Utente("Stefano Boeri", faker.internet().emailAddress());
        utenteSer.save(Utente1);
        utenteSer.save(Utente2);
        utenteSer.save(Utente3);

        Postazione postazione1 = new Postazione("A123A", "chiuso al buio", TipoPostazione.PRIVATO, 5, RenzoPianoBuilding);
        Postazione postazione2 = new Postazione("M000M", "angusto e tenebroso", TipoPostazione.OPENSPACE, 2, CucinellaArchitects);
        Postazione postazione3 = new Postazione("Z999Z", "l'ufficio dei sopranos", TipoPostazione.SALA_RIUNIONI, 100, BoeriArchitetti);
        postazioneSer.save(postazione1);
        postazioneSer.save(postazione2);
        postazioneSer.save(postazione3);

        Prenotazione prenotazione1 = new Prenotazione(LocalDate.now(), Utente1, postazione1);
        Prenotazione prenotazione2 = new Prenotazione(LocalDate.now(), Utente2, postazione2);
        Prenotazione prenotazione3 = new Prenotazione(LocalDate.now(), Utente3, postazione3);
        prenotazioneSer.save(prenotazione1);
        prenotazioneSer.save(prenotazione2);
        prenotazioneSer.save(prenotazione3);

// devo aggiungere giusto un'appunto per capire cosa sta succedendo, nel db o salvato tutte le prenotazioni e il try
// catch mi serve per verificare se lo stesso utente con la stessa data e altra postazione me lo fa salvare o mi cade
// giustamente nel catch come vuole la consegna

//        try {
//            Prenotazione prenotazione4 = new Prenotazione(LocalDate.now(), Utente1, postazione2);
//            prenotazioneSer.save(prenotazione4);
//        } catch (RuntimeException exception) {
//            System.out.println("cadi nel catch1111111111111" );
//        }
        // doppia prenotazione
//        try {
//            Prenotazione prenotazione5 = new Prenotazione(LocalDate.now(), Utente3, postazione3);
//            prenotazioneSer.save(prenotazione5);
//        } catch (RuntimeException exception) {
//            System.out.println("cadi nel catch22222");
//        }


    }
}

