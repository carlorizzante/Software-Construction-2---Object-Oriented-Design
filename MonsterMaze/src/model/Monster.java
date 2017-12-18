package model;

public class Monster extends Choice {

    private Treasure treasure;

    public Monster() {
        super("Fight a monster.");
        treasure = null;
    }

    // MODIFIES: this
    // EFFECTS:  Sets the treasure to t
    public void setTreasure(Treasure t) {
        this.treasure = t;
    }

    // EFFECTS: Prints result of choosing this choice
    public void printOutcome() {
        if (treasure == null) {
            System.out.println("Ha! I killed you!");
        } else {
            System.out.println("Ahh! You killed me!");
            treasure.printOutcome();
        }
    }

}
