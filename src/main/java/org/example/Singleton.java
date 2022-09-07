package org.example;

import java.util.ArrayList;
import java.util.HashSet;

public class Singleton {
    private HashSet<Teacher> teachers;
    private static Singleton singleton;
    private HashSet<Student> students;
    private Singleton() {}
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

    public static Singleton getSingleton()
    {
        if (singleton == null)
            singleton = new Singleton();
        return singleton;
    }

}
