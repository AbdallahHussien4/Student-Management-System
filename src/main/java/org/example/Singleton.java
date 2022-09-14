package org.example;

import java.util.ArrayList;
import java.util.HashSet;

public class Singleton {
    private static Singleton singleton;
    private HashSet<Teacher> teachers;
    private HashSet<Student> students;
    private HashSet<Course> courses;
    private HashSet<AssignmentSubmission> assignmentSubmissions;
    private HashSet<CourseAttendance> courseAttendances;

    private Singleton() {}
    public static Singleton getSingleton()
    {
        //TODO : Syncronized
        //Enum
        //Eagur
        if (singleton == null)
            singleton = new Singleton();
        return singleton;
    }
    public HashSet<Teacher> getTeachers()
    {
        if (teachers == null)
            teachers = new HashSet<Teacher>();
        return teachers;
    }
    public HashSet<Student> getStudents()
    {
        if (students == null)
            students = new HashSet<Student>();
        return students;
    }


    public HashSet<Course> getCourses()
    {
        if (courses == null)
            courses = new HashSet<Course>();
        return courses;
    }

    public HashSet<AssignmentSubmission> getAssignmentSubmissions()
    {
        if (assignmentSubmissions == null)
            assignmentSubmissions = new HashSet<AssignmentSubmission>();
        return assignmentSubmissions;
    }
    public HashSet<CourseAttendance> getCourseAttendances()
    {
        if (courseAttendances == null)
            courseAttendances = new HashSet<CourseAttendance>();
        return courseAttendances;
    }

}
