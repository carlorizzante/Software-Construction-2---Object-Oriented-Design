package exceptions;

public class WaterException extends Exception {

    public WaterException(double cups) {
        super("Wrong amount of water provided, " + String.valueOf(cups) + ".");
    }
}
