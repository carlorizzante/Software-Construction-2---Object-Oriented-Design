package exceptions;

public class StaleCoffeeException extends Exception {

    public StaleCoffeeException(int timeSinceLastBrew) {
        super("Coffee is stale since " + String.valueOf(timeSinceLastBrew) + " minutes.");
    }
}
