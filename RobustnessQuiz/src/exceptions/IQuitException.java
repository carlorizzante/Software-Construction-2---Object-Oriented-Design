package exceptions;

public class IQuitException extends Exception {
    public IQuitException() {
    }

    public IQuitException(String message) {
        super(message);
    }
}
