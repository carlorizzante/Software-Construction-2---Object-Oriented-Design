package model;

import exceptions.CourseFullException;
import exceptions.GPATooLowException;
import exceptions.MissingPrereqException;
import exceptions.NoCoursesTakenException;

import java.util.LinkedList;
import java.util.List;

public class Transcript {

    private String name;
    private int year;
    private int id;
    private double gpa;
    private List<Course> currentCourses;
    private List<Course> pastCourses;

    public Transcript(String studentName, int academicYear, int studentID) {
        this.name = studentName;
        this.year = academicYear;
        this.id = studentID;
        this.currentCourses = new LinkedList<>();
        this.pastCourses = new LinkedList<>();
    }

    // GETTERS
    public String getName() { return name; }
    public int getAcademicYear() { return year; }
    public int getId() { return id; }
    public List<Course> getCurrentCourses() { return currentCourses; }
    public List<Course> getPastCourses() { return pastCourses; }

    // REQUIRES: a non-empty list of past courses, i.e. size of pastCourses must be non-zero
    //           use the following formula to convert into a GPA
    //           GPA (4.0 scale) = (total percentage/20) - 1
    //           **Do you need a helper?**
    // EFFECTS:  computes cGPA. In this case, we take it to mean that it is the total grades received so far, divided
    //           by the number of past courses taken
    public double computeGPA() throws NoCoursesTakenException {
        if (pastCourses.isEmpty()) throw new NoCoursesTakenException("Can't calculate GPA, no course in record yet.");
        double totalGrades = 0.0;
        for (Course c : pastCourses) totalGrades += c.getGrade();
        return (totalGrades / pastCourses.size()) / 20 - 1;

    }

    // REQUIRES: the GPA computed from the pastCourses field needs to be over 2.6 (out of 4.0 scale)
    // EFFECTS: promotes the student represented by the transcript
    //          to the next academic year if the REQUIRES clause is met, and return true
    //          else return false with no change to the year field
    public boolean promoteStudent() throws GPATooLowException, NoCoursesTakenException {
        // TODO: complete the implementation of this method
        gpa = computeGPA();
        if (gpa <= 2.6) throw new GPATooLowException("Sorry, pal, you GPA is too low for promotion.");
        if (pastCourses.isEmpty()) throw new NoCoursesTakenException("You need to have passed at least one course to apply for promotion.");
        // If student qualifies, proceed with promotion
        year++;
        return true;
    }

    // REQUIRES: - check if the course you want to add is already in the list of past courses
    // MODIFIES: this
    // EFFECTS: adds the given course to the list of previously taken courses, given that the REQUIRES clause
    //          is fulfilled, and returns true. If the course is unable to be added, return false
    public boolean addToPastCourses(Course c) {
        if (!pastCourses.contains(c)) {
            pastCourses.add(c);
            return true;
        }
        return false;
    }

    // REQUIRES: this transcript must have all the necessary prerequisites in the pastCourses field
    //           The course you want to add must have space for more students to register
    // MODIFIES: this
    // EFFECTS:  adds a course (c) into the record
    public boolean addCourse(Course course) throws MissingPrereqException, CourseFullException {
        // You have to realize that there are a number of cases that your code needs to consider. What if the course
        // you wish to add has no prerequisites? What if the course you want to add is already full?
        // Careful consideration of these cases will lead to code that is correct
        if (course.isCourseFull()) throw new CourseFullException("Course reached max number of applicants.");
        if (pastCourses.isEmpty() && !course.getPrereq().isEmpty()) throw new MissingPrereqException("You do not qualify to register for the desired course.");
        if (!course.getPrereq().isEmpty()) for (Course prc : course.getPrereq()) if (!pastCourses.contains(prc)) return false;
        // If all is good, add the course to student curriculum and add increase student count for the course
        currentCourses.add(course);
        course.addStudent();
        return true;
    }


}