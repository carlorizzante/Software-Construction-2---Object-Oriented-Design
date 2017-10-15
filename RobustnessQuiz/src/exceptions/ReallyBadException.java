package exceptions;

public class ReallyBadException extends RecoverableException {
    public ReallyBadException() {
    }

    public ReallyBadException(String message) {
        super(message);
    }
}
