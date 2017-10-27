package model;

public class OnCampusStudent extends Student {

    public OnCampusStudent(int id, String name) {
        super(id, name);
    }

    @Override
    public void learn() {
        System.out.println("I will now go to class and have a nap.");
    }
}
