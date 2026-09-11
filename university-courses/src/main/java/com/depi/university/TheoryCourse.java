package com.depi.university;

/**
 * A Course that is taught in a classroom/lecture style.
 * Extends (inherits from) Course, so it automatically has "name"
 * and must provide its own getType().
 */
public class TheoryCourse extends Course {

    // An extra attribute specific to theory courses.
    private String classroom;

    public TheoryCourse(String name, String classroom) {
        // Constructor chaining: let the parent class (Course) set up "name".
        super(name);
        this.classroom = classroom;
    }

    @Override
    public String getType() {
        return "Theory";
    }

    @Override
    public String toString() {
        return "[Theory Course] " + name + " (Classroom: " + classroom + ")";
    }
}
