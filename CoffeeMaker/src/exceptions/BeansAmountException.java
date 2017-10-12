package exceptions;

public class BeansAmountException extends Exception {

    private double beans;

    public BeansAmountException(double beans) {
        super(String.valueOf(beans) + " is a incorrect amount of beans.");
    }

    protected BeansAmountException(double beans, String message) {
        super(String.valueOf(beans) + message);
    }

    public double getBeans() {
        return 0;
    }
}
