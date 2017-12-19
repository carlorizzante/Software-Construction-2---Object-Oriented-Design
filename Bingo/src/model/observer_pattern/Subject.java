package model.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<Observer> observers;

    public Subject(){
        observers = new ArrayList<>();
    }

    public List<Observer> getObservers() {
        return observers;
    }

    // MODIFIES: this
    // EFFECTS:  Adds observer_pattern to list of observers
    public void addObserver(Observer o) {
        observers.add(o);
    }

    // EFFECTS: Notifies observers of state change
    public abstract void notifyObservers();

}
