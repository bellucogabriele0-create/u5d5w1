package gabrielebelluco.u5d5w1.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("non è stato trovato ciò che cercavi con id: " + id);
    }

}
