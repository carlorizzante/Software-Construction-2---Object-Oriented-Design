package model;

public class Instructor {

    public final String name;
    private Course course;

    public Instructor(String name) { this.name = name; }

    public void setCourse(Course c) {
        this.course = c;
        if (!this.course.equals(c)) {
            this.course.addInstructor(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instructor that = (Instructor) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
