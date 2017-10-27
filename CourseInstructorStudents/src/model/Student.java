package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Student implements Teachable {

    private int id;
    private String name;
    private List<Course> courses = new ArrayList<>();

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

//    public void addCourse(Course c) {
//        courses.add(c);
//    }

    public void addCourse(Course c) {
        if (!this.courses.contains(c)) {
            this.courses.add(c);
            c.addStudent(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public void printRecord() {
        System.out.println(id + " : " + name);
    }
}
