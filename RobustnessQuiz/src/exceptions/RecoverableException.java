package exceptions;

public class RecoverableException extends Exception {
    public RecoverableException() {
    }

    public RecoverableException(String message) {
        super(message);
    }
}
