package com.depi.university;

/**
 * A Course that involves hands-on lab work.
 * Extends (inherits from) Course, same idea as TheoryCourse.
 */
public class LabCourse extends Course {

    // An extra attribute specific to lab courses.
    private int numberOfMachines;

    public LabCourse(String name, int numberOfMachines) {
        // Constructor chaining: let the parent class (Course) set up "name".
        super(name);
        this.numberOfMachines = numberOfMachines;
    }

    @Override
    public String getType() {
        return "Lab";
    }

    @Override
    public String toString() {
        return "[Lab Course] " + name + " (Machines available: " + numberOfMachines + ")";
    }
}
