package org.example;

import java.util.ArrayList;
import java.util.HashSet;


public class Singleton {
    private static Singleton singleton = new Singleton(); //Eager
    private HashSet<Teacher> teachers;
    private HashSet<Student> students;
    private HashSet<Course> courses;
    private HashSet<AssignmentSubmission> assignmentSubmissions;
    private HashSet<CourseAttendance> courseAttendances;

    /* Enum Implementation
      public enum Singleton {
        singleton;
        private Singleton() {
            teachers = new HashSet<Teacher>();
            students = new HashSet<Student>();
            courses = new HashSet<Course>();
            assignmentSubmissions = new HashSet<AssignmentSubmission>();
            courseAttendances = new HashSet<CourseAttendance>();
        }
    }*/
    private Singleton() {
        teachers = new HashSet<Teacher>();
        students = new HashSet<Student>();
        courses = new HashSet<Course>();
        assignmentSubmissions = new HashSet<AssignmentSubmission>();
        courseAttendances = new HashSet<CourseAttendance>();
    }
    public static Singleton getSingleton()
    {
        //Enum
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
    public HashSet<Teacher> getTeachers()
    {
        return teachers;
    }
    public HashSet<Student> getStudents()
    {
        return students;
    }
    public HashSet<Course> getCourses()
    {
        return courses;
    }

    public HashSet<AssignmentSubmission> getAssignmentSubmissions()
    {
        return assignmentSubmissions;
    }
    public HashSet<CourseAttendance> getCourseAttendances()
    {
        return courseAttendances;
    }

}
