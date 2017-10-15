package model;

import exceptions.BadException;
import exceptions.IQuitException;
import exceptions.OhNoException;
import exceptions.ReallyBadException;

public class A {
    public void doA(String string) throws BadException, IQuitException, ReallyBadException {
        if (string.length() > 1) {
            B b = new B();
            try {
                b.doB(string);
            } catch (OhNoException e) {
                System.out.println("Oh no!");
                throw new IQuitException();
            }
        } else {
            throw new BadException();
        }
        System.out.println("I knew I shouldn't have taken this job.");
    }
}
