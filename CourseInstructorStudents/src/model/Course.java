package model;

import java.util.ArrayList;
import java.util.List;

public class Course {

    public String courseName;
    private Instructor instructor;
    private List<Student> students = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addInstructor(Instructor instructor) { this.instructor = instructor; }

//    public void addStudent(Student student) {
//        students.add(student);
//    }

    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
            this.students.add(student);
            student.addCourse(this);
        }
    }

    public void printEnrolled() {
        for (Student s : students) s.printRecord();
    }

    public void setInstructor(Instructor inst) {
        if (!this.instructor.equals(inst)) {
            this.instructor = inst;
            this.instructor.setCourse(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return courseName.equals(course.courseName);
    }

    @Override
    public int hashCode() {
        return courseName.hashCode();
    }
}
