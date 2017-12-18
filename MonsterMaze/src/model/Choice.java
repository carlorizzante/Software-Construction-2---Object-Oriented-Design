package model;

public abstract class Choice {

    private String message;

    public Choice(String message) {
        this.message = message;
    }

    // EFFECTS: Prints out the message that describes this choice
    public void printMessage() {
        System.out.println(this.message);
    }

    // EFFECTS: Prints out result of this choice
    public abstract void printOutcome();
}
