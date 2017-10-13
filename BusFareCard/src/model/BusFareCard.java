package model;

import exceptions.IllegalAgeException;
import exceptions.IllegalAmountException;
import exceptions.MissingFareException;
import exceptions.NoBalanceException;

public class BusFareCard {

    private static final int AGE_CUTOFF = 18;
    public static final double ADULT_FARE = 2.75;
    public static final double CONCESSION_FARE = 1.75;
    private String ownerName;
    private int ownerAge;
    private double balance;
    private boolean fareLoaded;

    public BusFareCard(String nm, int age, double initialLoad) throws IllegalAmountException {
        if (initialLoad < 0) {
            throw new IllegalAmountException("$" + initialLoad + " is not a valid amount to load onto your card.");
        } else {
            ownerName = nm;
            ownerAge = age;
            balance = initialLoad;
            fareLoaded = false;
        }
    }

    // getters
    public String getName() { return ownerName; }
    public int getAge() { return ownerAge; }
    public double getBalance() { return balance; }
    public boolean isFareLoaded() { return fareLoaded; }

    // REQUIRES: the age of this card must be > AGE_CUTOFF
    //           the balance on this card must be >= 0 after purchasing the card
    // MODIFIES: this
    // EFFECTS: if the REQUIRES clause is fulfilled, subtract cost of the adult fare from the balance
    //          and set the isFareLoaded field to true
    public void purchaseAdultFare() throws IllegalAgeException, NoBalanceException {
        if (ownerAge <= AGE_CUTOFF) throw new IllegalAgeException("No need to buy an adult fare since you are eligible for a concession fare.");
        if (balance - ADULT_FARE < 0) throw new NoBalanceException("Sorry, your balance of " + String.valueOf(balance) + " is insufficient for the current purchase.");
        balance = balance - ADULT_FARE;
        fareLoaded = true;
    }

    // REQUIRES: the age of this card must be <= AGE_CUTOFF
    //           the balance on this card must be >= 0 after purchasing the card
    // MODIFIES: this
    // EFFECTS: if the REQUIRES clauses is fulfilled, subtract cost of a concession fare from the balance
    //          and set the isFareLoaded field to true
    public void purchaseConcessionTicket() throws IllegalAgeException, NoBalanceException {
        if (ownerAge > AGE_CUTOFF) throw new IllegalAgeException("Sorry, you are not eligible for a concession fare, please purchase a different one.");
        if (balance - CONCESSION_FARE < 0) throw new NoBalanceException("Sorry, your balance of " + String.valueOf(balance) + " is insufficient for the current purchase.");
        balance = balance - CONCESSION_FARE;
        fareLoaded = true;
    }

    // REQUIRES: amount you want to load onto the card must be > 0
    // MODIFIES: this
    // EFFECTS: loads the specified amount onto the card's balance field
    public void reloadBalance(double amount) throws IllegalAmountException {
        if (amount < 0) throw new IllegalAmountException("Positive amount required for reloading your balance.");
        balance += amount;
    }

    // REQUIRES: the fareLoaded field must be true in order to "board" a bus
    // MODIFIES: this
    // EFFECTS: sets fareLoaded field to false, else throws exception
    public void boardBus() throws MissingFareException {
        //TODO: complete the implementation of this method
        if (!fareLoaded) throw new MissingFareException("Sorry, to be allowed to board you must first purchase a valid fare.");
        fareLoaded = false;
    }


}