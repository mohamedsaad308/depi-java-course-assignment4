package com.depi.university;

import java.util.ArrayList;
import java.util.List;

/**
 * A Department can contain multiple students and multiple courses.
 * The course list is List<Course>, which is where the polymorphism
 * requirement really shows: the same list happily stores both
 * TheoryCourse and LabCourse objects.
 */
public class Department {

    private String name;
    private List<Course> courses;
    private List<Student> students;

    public Department(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    /**
     * Displays every course in the department.
     * Polymorphism in action: course.toString() runs TheoryCourse's
     * or LabCourse's own version depending on the real object type,
     * even though the loop variable is declared simply as "Course".
     */
    public void displayAllCourses() {
        System.out.println("=== Courses offered by " + name + " ===");
        for (Course course : courses) {
            System.out.println("   " + course);
        }
    }

    /**
     * Displays every student in the department along with the
     * courses each one is enrolled in.
     */
    public void displayAllStudents() {
        System.out.println("=== Students in " + name + " ===");
        for (Student student : students) {
            student.displayCourses();
        }
    }
}
