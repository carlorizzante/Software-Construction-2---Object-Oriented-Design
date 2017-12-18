package model;

import java.util.List;

public class Order {

    private Dish dish;
    private int number;
    private boolean served;
    private boolean prepared;

    public Order(Dish dish, int number) {
        this.dish = dish;
        this.number = number;
    }

    // GETTERS
    public Dish getDish() { return dish; }
    public int getNumber() { return number; }
    public boolean isServed() { return served; }
    public boolean isPrepared() { return prepared; }

    // SETTERS
    public void setDish(Dish dish) { this.dish = dish; }                  // dish != null
    public void setNumber(int number) { this.number = number; }
    public void setServed(boolean served) { this.served = served; }
    public void setPrepared(boolean prepared) { this.prepared = prepared; }

    // EFFECTS: Prints current order with number, dish, and any modification.
    public void print() {
        System.out.print("Order #" + number);
        System.out.print(" -> ");
        printNot(prepared);
        System.out.print("Prepared, ");
        printNot(served);
        System.out.println("Served.");
    }

    // EFFECTS: Returns true if order not prepared yet
    public boolean needsToBePrepared() {
        return !prepared;
    }

    // EFFECTS: Returns true if order is prepared but not served yet
    public boolean isReadyToBeServed() {
        return prepared && !served;
    }

    // EFFECTS: Returns true if order is prepared and served
    public boolean isReadyToBePaid() {
        return prepared && served;
    }

    public void printNot(boolean status) {
        if (!status) System.out.print("Not ");
    }

    // EFFECTS: Returns recipe to follow for this order
    public String getOrderRecipe() {
        return dish.getRecipe();
    }

    // EFFECTS: Returns list of ingredients needed for this order
    public List<String> getOrderIngredients() {
        return dish.getIngredients();

    }
}