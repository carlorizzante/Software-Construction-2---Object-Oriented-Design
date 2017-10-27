package model;

public class OnlineStudent extends Student {

    public OnlineStudent(int id, String name) {
        super(id, name);
    }

    @Override
    public void learn() {
        System.out.println("I will now go online and play Call of Duty.");
    }
}
