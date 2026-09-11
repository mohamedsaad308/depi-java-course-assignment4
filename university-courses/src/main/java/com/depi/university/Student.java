package com.depi.university;

import java.util.ArrayList;
import java.util.List;

/**
 * A Student can enroll in any kind of Course (Theory or Lab).
 * We store enrolled courses as List<Course> so a Student's course
 * list can freely mix both subclasses (polymorphism).
 */
public class Student {

    private String name;
    private List<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    /**
     * Enroll this student in a course. Notice the parameter type is
     * "Course", the abstract parent type, so this single method works
     * for both TheoryCourse and LabCourse objects.
     */
    public void enroll(Course course) {
        enrolledCourses.add(course);
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    /**
     * Prints this student's name followed by every course they are
     * enrolled in. Because the list holds Course references but the
     * real objects are TheoryCourse/LabCourse, calling toString() on
     * each one runs the correct overridden version automatically.
     */
    public void displayCourses() {
        System.out.println("Student: " + name);
        if (enrolledCourses.isEmpty()) {
            System.out.println("   (not enrolled in any course yet)");
            return;
        }
        for (Course course : enrolledCourses) {
            System.out.println("   - " + course);
        }
    }

    @Override
    public String toString() {
        return "Student{name=" + name + "}";
    }
}
