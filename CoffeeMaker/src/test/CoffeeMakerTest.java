package test;


import exceptions.*;
import model.CoffeeMaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CoffeeMakerTest {

    CoffeeMaker coffeeMaker;

    @Before
    public void setup() {
        coffeeMaker = new CoffeeMaker();
    }


    @Test
    public void testConstructor() {
        assertEquals(coffeeMaker.getTimeSinceLastBrew(), 0);
        assertEquals(coffeeMaker.getCupsRemaining(), 0);
    }

    @Test
    public void testValidBrew() {
        try {
            coffeeMaker.brew(2.5,15);
            assertEquals(coffeeMaker.getTimeSinceLastBrew(), 0);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testValidBrews() {
        try {
            coffeeMaker.brew(2.5,15);
            coffeeMaker.brew(2.4,14.9);
            coffeeMaker.brew(2.55,15.1);
            assertEquals(coffeeMaker.getTimeSinceLastBrew(), 0);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testNotEnoughBeans() {
        try {
            coffeeMaker.brew(2.35, 15);
        } catch (NotEnoughBeansException e) {
            // all good here
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testTooManyBeans() {
        try {
            coffeeMaker.brew(2.65, 15);
        } catch (TooManyBeansException e) {
            // all good here
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testInsufficientWater() {
        try {
            coffeeMaker.brew(2.5, 14.7);
        } catch (WaterException e) {
            // all good here
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testPourCoffee() {
        try {
            coffeeMaker.brew(2.5,15);
            coffeeMaker.pourCoffee();
            assertEquals(coffeeMaker.getCupsRemaining(), 19);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testPourMoreCoffee() {
        try {
            coffeeMaker.brew(2.5,15);
            coffeeMaker.pourCoffee();
            coffeeMaker.pourCoffee();
            coffeeMaker.pourCoffee();
            coffeeMaker.pourCoffee();
            coffeeMaker.pourCoffee();
            coffeeMaker.pourCoffee();
            coffeeMaker.pourCoffee(); // 7 cups!
            assertEquals(coffeeMaker.getCupsRemaining(), 13);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSetTimeSinceLastBrew() {
        try {
            coffeeMaker.brew(2.5,15);
            assertEquals(coffeeMaker.getTimeSinceLastBrew(), 0);
            coffeeMaker.setTimeSinceLastBrew(70);
            assertEquals(coffeeMaker.getTimeSinceLastBrew(), 70);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSetInvalidTimeSinceLastBrew() {}

    @Test
    public void testAttemptPourStaleCoffee() {
        try {
            coffeeMaker.brew(2.5,15);
            coffeeMaker.setTimeSinceLastBrew(61);
            coffeeMaker.pourCoffee();
        } catch (StaleCoffeeException e) {
            // all good here
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testNoCupsRemaining() {
        try {
            coffeeMaker.brew(2.5, 15);
            for (int i = 0; i < 20; i++) {
                coffeeMaker.pourCoffee();
            }
            coffeeMaker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            // all good here
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAreCupsRemaining() throws BeansAmountException, WaterException, StaleCoffeeException, NoCupsRemainingException {
        coffeeMaker.brew(2.5,15);
        assertEquals(coffeeMaker.areCupsRemaining(), true);
        coffeeMaker.pourCoffee();
        assertEquals(coffeeMaker.areCupsRemaining(), true);
        for (int i = 0; i < 19; i++) {
            coffeeMaker.pourCoffee();
        }
        assertEquals(coffeeMaker.areCupsRemaining(), false);
    }



}
