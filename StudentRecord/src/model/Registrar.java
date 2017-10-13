package model;
import exceptions.CourseFullException;
import exceptions.MissingPrereqException;

import java.util.LinkedList;
import java.util.List;

public class Registrar {

    private String name;
    private List<Transcript> students;

    public Registrar(String name) {
        this.name = name;
        students = new LinkedList<>();
    }

    // getters
    public String getName() { return name; }
    public List<Transcript> getStudents() { return students; }

    // MODIFIES: this
    // EFFECTS: returns true if the student (represented as a transcript) was successfully added to the
    //          Registrar's list. Remember to check if the student already exists in the list
    public boolean addStudent(Transcript stu) {
        if (!students.contains(stu)) {
            students.add(stu);
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: that the student represented by the transcript has the necessary prerequisite required
    //           to take the course.
    // MODIFIES: the transcript object passed in as parameter
    // EFFECTS:  given the REQUIRES clause holds, the student represented by the transcript is registered in the given
    //           course
    public boolean registerStudent(Course c, Transcript tct) {
        try {
            tct.addCourse(c);
            return true;
        } catch (MissingPrereqException | CourseFullException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // EFFECTS: promotes all students to their next year level. It should throw GPATooLowException or
    //          NoCoursesTakenException
    public void promoteAllStudents() {
        for (Transcript student : students) {
            try {
                student.promoteStudent();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


}