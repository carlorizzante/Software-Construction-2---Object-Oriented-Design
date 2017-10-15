package main;

import exceptions.BadException;
import exceptions.IQuitException;
import exceptions.ReallyBadException;
import exceptions.RecoverableException;
import model.A;

public class ExceptionThrower {
    public static void main(String[] args) throws BadException, ReallyBadException {
        String string = "a";  // (*)
        A a = new A();
        try {
            a.doA(string);
        } catch (RecoverableException e) {
            System.out.println("Phew! It's all okay");
        } catch (IQuitException e) {
            System.out.println("It's not okay");
        } finally {
            System.out.println("I'm too old for this.");
        }
    }
}