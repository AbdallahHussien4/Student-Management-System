package org.example;

import java.util.ArrayList;

public class TeachersStudentsSingleton {
    private static ArrayList<Teacher> teachers;
    private static ArrayList<Student> students;
    public static ArrayList<Teacher> getTeachers()
    {
        if (teachers == null)
            teachers = new ArrayList<Teacher>();
        return teachers;
    }
    public static ArrayList<Student> getStudents()
    {
        if (students == null)
            students = new ArrayList<Student>();
        return students;
    }

}
