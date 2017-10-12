package ui;

import exceptions.WrongShoesException;
import model.Weather;

public class Main {

    public static void main(String[] args) throws WrongShoesException {

        Weather weather1 = new Weather(25, false, true);
//        weather1.getWeather();

        Weather weather2 = new Weather(-5, false, true);
//        weather2.getWeather();

        Weather weather3 = new Weather(65, true, true);
//        weather3.getWeather();

        Weather weather4 = new Weather(-10, true, true);
        weather4.getWeather();
    }
}
