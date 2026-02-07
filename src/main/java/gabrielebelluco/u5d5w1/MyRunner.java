package gabrielebelluco.u5d5w1;

import com.github.javafaker.Faker;
import gabrielebelluco.u5d5w1.Service.EdificioSer;
import gabrielebelluco.u5d5w1.Service.PostazioneSer;
import gabrielebelluco.u5d5w1.Service.PrenotazioneSer;
import gabrielebelluco.u5d5w1.Service.UtenteSer;
import gabrielebelluco.u5d5w1.entities.Edificio;
import gabrielebelluco.u5d5w1.entities.TipoPostazione;
import gabrielebelluco.u5d5w1.entities.Utente;
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

        edificioSer.aggiuntaEdificio(RenzoPianoBuilding);
        edificioSer.aggiuntaEdificio(CucinellaArchitects);
        edificioSer.aggiuntaEdificio(BoeriArchitetti);
        Utente Utente1 = new Utente("Renzo Piano", faker.internet().emailAddress());
        Utente Utente2 = new Utente("Mario Cucinella", faker.internet().emailAddress());
        Utente Utente3 = new Utente("Stefano Boeri", faker.internet().emailAddress());
        utenteSer.addUtente(Utente1);
        utenteSer.addUtente(Utente2);
        utenteSer.addUtente(Utente3);

        postazioneSer.addPostazione("A123A", 1, TipoPostazione.PRIVATO, "chiuso al buio", 5);
        postazioneSer.addPostazione("M000M", 2, TipoPostazione.OPENSPACE, "angusto e tenebroso", 2);
        postazioneSer.addPostazione("Z999Z", 3, TipoPostazione.SALA_RIUNIONI, "l'ufficio dei sopranos", 100);


        prenotazioneSer.addPrenotazione(1l, 1l, LocalDate.of(2026, 6, 2));
        prenotazioneSer.addPrenotazione(3l, 3l, LocalDate.of(2026, 6, 1));

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

