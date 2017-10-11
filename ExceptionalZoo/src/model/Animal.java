package model;

public class Animal {

    private boolean isHungry = true;
    private boolean hungry;
    private int eaten = 0;

    // getters
    public boolean isHungry() { return hungry; }

    // REQUIRES: hungry = true
    public int eat() {
        isHungry = false;
        eaten ++;
        return eaten;
    }
}