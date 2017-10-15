package model;

import exceptions.OhNoException;
import exceptions.ReallyBadException;
import exceptions.TooLongException;

public class B {
    public void doB(String string) throws OhNoException, ReallyBadException {
        C c = new C();
        try {
            c.doC(string);
        } catch (TooLongException e) {
            System.out.println("Too long? This is bad. Is it really bad?");
            if (string.length() > 5) {
                System.out.println("It's Bad!");
                throw new ReallyBadException();
            } else if (string.length() > 3) {
                System.out.println("Really Bad!");
                throw new OhNoException();
            }
        } finally {
            System.out.println("I should call my manager!");
        }
    }
}