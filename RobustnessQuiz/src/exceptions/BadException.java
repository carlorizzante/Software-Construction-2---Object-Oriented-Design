package exceptions;

public class BadException extends RecoverableException {
    public BadException() {
    }

    public BadException(String message) {
        super(message);
    }
}
