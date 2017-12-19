package model.random;

public class NumberSquare extends RandomNumber {

    private boolean stamped;

    public NumberSquare(){
        super();
    }

    // EFFECTS: Returns true if stamped
    public boolean isStamped(){
        return stamped;
    }

    // MODIFIES: this
    // EFFECTS:  Stamps this number square
    public void stamp() {
        stamped = true;
    }

}
