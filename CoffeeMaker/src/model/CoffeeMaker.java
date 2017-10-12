package model;

import exceptions.*;

public class CoffeeMaker {

    private int timeSinceLastBrew;
    private int cupsRemaining;

    // EFFECTS: Sets timeSinceLastBrew and cupsRemaining to 0
    public CoffeeMaker() {
        timeSinceLastBrew = 0;
        cupsRemaining = 0;
    }

    // Getters
    public int getTimeSinceLastBrew() { return timeSinceLastBrew; }
    public int getCupsRemaining() { return cupsRemaining; }

    // EFFECTS: Returns true if there are coffee cups remaining
    public boolean areCupsRemaining() { return cupsRemaining > 0; }

    // REQUIRES: A non-negative integer (natural)
    // EFFECTS: Sets time since last brew
    // INVARIANT: positive integer for time required
    public void setTimeSinceLastBrew(int time) throws Exception {
        timeSinceLastBrew = time;
    }

    // REQUIRES: Beans between 2.40 and 2.60 cups, water between 14.75 and 15.1 cups
    // EFFECTS: Sets cupsRemaining to 20 and resets timeSinceLastBrew to 0
    //          Throws BeansAmountException if beans not in valid range
    //          Throws WaterException if water not in valid range
    public void brew(double beans, double water) throws BeansAmountException, WaterException {
        timeSinceLastBrew = 0;
        cupsRemaining = 20;
        if (beans < 2.40) throw new NotEnoughBeansException(beans);
        if (beans > 2.60) throw new TooManyBeansException(beans);
        if (water < 14.75 || water > 15.1) throw new WaterException(water);
    }

    // REQUIRES: Cups remaining > 0, time since last brew < 60
    // MODIFIES: This
    // EFFECTS: Subtracts one cup from cups remaning
    public void pourCoffee() throws StaleCoffeeException, NoCupsRemainingException {
        if (cupsRemaining <= 0) throw new NoCupsRemainingException();
        if (timeSinceLastBrew > 60) throw new StaleCoffeeException(timeSinceLastBrew);
        cupsRemaining = cupsRemaining - 1;
    }

}
