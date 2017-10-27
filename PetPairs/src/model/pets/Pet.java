package model.pets;

import model.Human;

public class Pet {

    protected boolean friendly;
    protected boolean needsAttention;
    protected String species;
    protected String color;
    protected double price;

    private Human human = null;

    public Pet(String species, String color, boolean friendly, boolean needsAttention, double price){
        this.friendly = friendly;
        this.needsAttention = needsAttention;
        this.species = species;
        this.color = color;
        this.price = price;
    }

    public Pet(String species, String color, double price){
        this.species = species;
        this.color = color;
        this.price = price;
    }

    public boolean isFriendly() { return friendly; }
    public boolean needsAttention() { return needsAttention; }
    public String getSpecies() { return species; }
    public double getPrice() { return price; }

    public Human getHuman() { return this.human; }

    // REQUIRES: human != null
    // MODIFIES: this, human
    // EFFECTS:  adopts human, and vice versa
    public void adoptHuman(Human human) {
        System.out.println("Adopting an human!");
        this.human = human;

        if (!human.hasPet(this)) {
            human.adoptPet(this);
        }
        System.out.println("Human successfully adopted: " + human);
    }

    @Override
    public String toString() {
        return "Pet {" +
                "species='" + species + '\'' +
                ", friendly=" + friendly +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", human= " + human + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;

        Pet pet = (Pet) o;

        if (!species.equals(pet.species)) return false;
        return color.equals(pet.color);
    }

    @Override
    public int hashCode() {
        int result = species.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }
}
