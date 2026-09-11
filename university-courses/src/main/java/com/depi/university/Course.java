package com.depi.university;

/**
 * Abstract base class for every course offered by the university.
 *
 * "Abstract" means we can never create a plain Course object directly
 * (new Course(...) is not allowed). Instead, we must use one of its
 * concrete subclasses: TheoryCourse or LabCourse.
 *
 * This is the "Abstract class" requirement from the task.
 */
public abstract class Course {

    // Attribute shared by every kind of course.
    protected String name;

    /**
     * Every subclass constructor will call this one using super(name),
     * which is what the task calls "constructor chaining".
     */
    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Abstract method: every subclass MUST provide its own version
     * of this method. It returns the type of the course as text,
     * e.g. "Theory" or "Lab".
     *
     * This is what makes polymorphism possible later: when we call
     * getType() on a Course reference, Java automatically runs the
     * correct subclass version depending on the real object.
     */
    public abstract String getType();

    /**
     * A default toString() so every Course has a readable text form.
     * Subclasses override this to add their own details.
     */
    @Override
    public String toString() {
        return "[" + getType() + " Course] " + name;
    }
}
