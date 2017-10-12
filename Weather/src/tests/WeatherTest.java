package tests;

import exceptions.IHateColdException;
import exceptions.ImpossibleException;
import exceptions.ImpossibleTempException;
import model.Weather;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class WeatherTest {

    private Weather weather;

    @Before
    public void setup() {
        weather = new Weather(0, false, false);
    }

    @Test
    public void testSnowing() {
        weather.setSnowing(true);
        weather.setTemperature(-5);
        try {
            weather.analyzeWeather();
        } catch (IHateColdException e) {
            // all good here
        } catch (ImpossibleException e) {
            fail();
        }
    }

    @Test
    public void testImpossibleTemperature() {
        weather.setTemperature(100);
        try {
            weather.analyzeWeather();
        } catch (ImpossibleTempException e) {
            // all good here
        }
    }
}
