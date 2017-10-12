package tests;


import exceptions.AllergyException;
import exceptions.NotHungry;
import model.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class AnimalTest {

    @Test
    public void isHungryNotAllergic() {
        int eatenTimes = 0;
        Animal animal = new Animal(true, false);
        try {
            eatenTimes = animal.eat();
        } catch (AllergyException e) {
            fail("Allergy exception wrongly thrown.");
        } catch (NotHungry notHungry) {
            fail("NotHungry exception wrongly thrown.");
        } finally {
            assertTrue(eatenTimes == 1);
        }
    }

    @Test
    public void notHungryNotAllergic() {
        int eatenTimes = 0;
        Animal animal = new Animal(false, false);
        try {
            eatenTimes = animal.eat();
        } catch (AllergyException e) {
            fail("Allergy exception wrongly thrown.");
        } catch (NotHungry notHungry) {
            // All good here, expected exception
        } finally {
            assertTrue(eatenTimes == 0);
        }
    }

    @Test
    public void isHungryIsAllergic() {
        int eatenTimes = 0;
        Animal animal = new Animal(true, true);
        try {
            eatenTimes = animal.eat();
        } catch (AllergyException e) {
            // All good here, expected exception
        } catch (NotHungry notHungry) {
            fail("NotHungry exception wrongly thrown.");
        } finally {
            assertTrue(eatenTimes == 0);
        }
    }

    @Test
    public void notHungryIsAllergic() {
        int eatenTimes = 0;
        Animal animal = new Animal(false, true);
        try {
            eatenTimes = animal.eat();
        } catch (AllergyException e) {
            fail("Allergy exception wrongly thrown.");
        } catch (NotHungry notHungry) {
            // All good here, expected exception
        } finally {
            assertTrue(eatenTimes == 0);
        }
    }

}
