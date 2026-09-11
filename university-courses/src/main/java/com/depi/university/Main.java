package com.depi.university;

/**
 * Entry point of the program.
 *
 * Walks through everything the task asks for:
 *  1) Creates one department
 *  2) Adds both Theory and Lab courses
 *  3) Creates two students and enrolls them in different courses
 *  4) Displays all courses and the courses of each student
 */
public class Main {

    public static void main(String[] args) {

        // 1) Create one department
        Department csDepartment = new Department("Computer Science");

        // 2) Add both Theory and Lab courses
        // Notice: both are created as their concrete subclass,
        // but they are still "Course" objects underneath.
        Course java101 = new TheoryCourse("Java Fundamentals", "Room A1");
        Course dbTheory = new TheoryCourse("Database Systems", "Room B2");
        Course javaLab = new LabCourse("Java Programming Lab", 25);
        Course networkLab = new LabCourse("Networking Lab", 15);

        csDepartment.addCourse(java101);
        csDepartment.addCourse(dbTheory);
        csDepartment.addCourse(javaLab);
        csDepartment.addCourse(networkLab);

        // 3) Create two students and enroll them in different courses
        Student ahmed = new Student("Ahmed");
        Student mina = new Student("Mina");

        ahmed.enroll(java101);
        ahmed.enroll(javaLab);

        mina.enroll(dbTheory);
        mina.enroll(networkLab);
        mina.enroll(javaLab); // a student can share a course with another student

        csDepartment.addStudent(ahmed);
        csDepartment.addStudent(mina);

        // 4) Display all courses and the courses of each student
        csDepartment.displayAllCourses();
        System.out.println();
        csDepartment.displayAllStudents();
    }
}
