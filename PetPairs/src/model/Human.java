package model;

import model.pets.Pet;

import java.util.ArrayList;

public class Human {

    private String name;
    private double spendibees;
    private ArrayList<Pet> pets; // Todo x

    public Human(String name) {
        this.name = name;
        this.spendibees = 0;
        this.pets = new ArrayList<>(); // Todo x
    }

    public double getSpendibees() { return spendibees; }
    public boolean hasPet(Pet pet) { return this.pets.contains(pet); }

    // REQUIRES: this can afford pet
    // MODIFIES: this, pet
    // EFFECTS:  if this can afford pet, adopt pet and have pet adopt human
    public void adoptPet(Pet pet) {
        System.out.println("Adopting a pet!");
        if (!this.pets.contains(pet)) {
            spendSpendibees(pet.getPrice());
            this.pets.add(pet);
            pet.adoptHuman(this);
            System.out.println("Success! Adopted " + pet);
        }
    }

    // REQUIRES: pet != null
    // EFFECTS:  returns true if this has enough money to buy pet
    public boolean canAffordPet(Pet pet) {
        return spendibees >= pet.getPrice();
    }

    // MODIFIES: this
    // EFFECTS:  adds spendibees to this account
    public void addSpendibees(double spendibees) {
        this.spendibees += spendibees;
    }

    @Override
    public String toString() {
        return "Human: " + name;
    }

    // REQUIRES: spent >= spendibees
    // MODIFIES: this
    // EFFECTS:  reduces spendibees by spent
    private void spendSpendibees(double spend) {
        this.spendibees -= spend;
    }

    // EFFECTS: returns the number of pets belonging to species
     public int numPetsOfSpecies(String species) {
         int count = 0;
         for (Pet p : pets) {
             if (p.getSpecies() == species) {
                 count ++;
             }
         }
        return count;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        return name.equals(human.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
