package ui;

import model.Course;
import model.Instructor;
import model.OnlineStudent;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem {

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Instructor> instructors = new ArrayList<>();

    public RegistrationSystem() {
        Instructor gregor = new Instructor("Gregor");
        Instructor elisa = new Instructor("Elisa");
        Instructor reid = new Instructor("Reid");
        instructors.add(gregor);
        instructors.add(elisa);
        instructors.add(reid);

        Course howtocode = new Course("How to Code");
        howtocode.addInstructor(gregor);
        courses.add(howtocode);

        Course softwareconstruction = new Course("Software Construction");
        softwareconstruction.addInstructor(elisa);
        courses.add(softwareconstruction);

        Course softwareEng = new Course("Software Engineering");
        softwareEng.addInstructor(reid);
        courses.add(softwareEng);

        registerStudent(new OnlineStudent(1, "Erika"), softwareconstruction);
    }

    public void registerStudent(Student s, Course c) {
        c.addStudent(s);
        s.addCourse(c);
    }

    public static void main(String[] args) {
        new RegistrationSystem();
    }
}

