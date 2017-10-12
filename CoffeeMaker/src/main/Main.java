package main;

import exceptions.BeansAmountException;
import exceptions.NoCupsRemainingException;
import exceptions.StaleCoffeeException;
import exceptions.WaterException;
import model.CoffeeMaker;

public class Main {

    public static void main(String[] args) {

        CoffeeMaker coffeMaker = new CoffeeMaker();

        try {
            coffeMaker.brew(2.5,15);
            coffeMaker.pourCoffee();
            System.out.println("Nice coffee!");
            System.out.println("There are still " + coffeMaker.getCupsRemaining() + " cups remaining.");
        } catch (Exception e) {
            System.out.println("No Exceptions should be thrown at this stage.");
        }

        try {
            coffeMaker.setTimeSinceLastBrew(17);
            coffeMaker.pourCoffee();
            coffeMaker.pourCoffee();
            System.out.println("More coffee, thanks!");
        } catch (Exception e) {
            System.out.println("No Exceptions should be thrown if there are still cups and timing is good.");
        }

        try {
            coffeMaker.brew(3, 15);
            System.out.println("Too many beans!");
        } catch (BeansAmountException e) {
            System.out.println(e.getMessage());
        } catch (WaterException e) {
            System.out.println("WaterException shouldn't be thrown.");
        } catch (Exception e) {
            System.out.println("Wrong exception.");
        }

        try {
            coffeMaker.brew(2.1, 15);
            System.out.println("Too few beans!");
        } catch (BeansAmountException e) {
            System.out.println(e.getMessage());
        } catch (WaterException e) {
            System.out.println("WaterException shouldn't be thrown.");
        } catch (Exception e) {
            System.out.println("Wrong exception.");
        }

        try {
            coffeMaker.brew(2.5, 21);
            System.out.println("Too much water!");
        } catch (WaterException e) {
            System.out.println(e.getMessage());
        } catch (BeansAmountException e) {
            System.out.println("BeansAmountException shouldn't be thrown");
        } catch (Exception e) {
            System.out.println("Wrong exception.");
        }

        try {
            coffeMaker.brew(2.5,15);
            coffeMaker.pourCoffee();
            coffeMaker.setTimeSinceLastBrew(61);
            System.out.println("Coffee is not longer fresh, but...");
            coffeMaker.pourCoffee();
        } catch (StaleCoffeeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Wrong exception");
        }

        try {
            coffeMaker.brew(2.5,15);
            for (int i = 0; i < 20; i++) {
                coffeMaker.pourCoffee();
            }
            coffeMaker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Wrong exception.");
        }
    }
}
