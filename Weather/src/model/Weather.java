package model;

import exceptions.*;

public class Weather {

    private int temperature;
    private boolean raining;
    private boolean snowing;

    public Weather(int temperature, boolean raining, boolean snowing) {
        this.temperature = temperature;
        this.raining = raining;
        this.snowing = snowing;
    }

    // Getter & Setters
    public int getTemperature() { return temperature; }
    public void setTemperature(int temperature) { this.temperature = temperature; }
    public boolean isRaining() { return raining; }
    public void setRaining(boolean raining) { this.raining = raining; }
    public boolean isSnowing() { return snowing; }
    public void setSnowing(boolean snowing) { this.snowing = snowing; }

    public void analyzeWeather() throws ImpossibleTempException, ImpossiblePrecipException, IHateColdException {

        System.out.println("How's the weather today?");

        if (temperature < -50 || temperature > 60) {
            throw new ImpossibleTempException();

        } else if (temperature < 0) {
            throw new IHateColdException();

        } else if (temperature <= 30) {
            System.out.println("Perfect weather!");

            if (raining) {
                System.out.println("What a shame.");
            }
            if (snowing) {
                throw new ImpossiblePrecipException();
            }
        }
        System.out.println("Enjoy the weather!");
    }

    public void getWeather() {
        try {
            analyzeWeather();
        } catch (ImpossibleException e) {
            System.out.println("The weather is not possible.");
        } finally {
            System.out.println("I hate the cold.");
        }
    }
}
