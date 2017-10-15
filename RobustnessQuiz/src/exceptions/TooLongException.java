package exceptions;

public class TooLongException extends Exception {
    public TooLongException() {
    }

    public TooLongException(String message) {
        super(message);
    }
}
