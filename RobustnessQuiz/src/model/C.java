package model;

import exceptions.TooLongException;

public class C {
    public void doC(String string) throws TooLongException {
        System.out.println("Today's going to be a good day!");
        if (string.length() > 5) {
            throw new TooLongException();
        } else {
            System.out.println("The word of the day is " + string + "!");
        }
    }
}