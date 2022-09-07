package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ////////////Create Admin///////////////////
        Admin admin = new Admin("1","Admin 1","Admin@School.com","0123456789");

        ////////////Test Teacher///////////////////
        admin.addTeacher("1","Teacher 1","Teacher1@School.com","011111111");
        admin.addTeacher("2","Teacher 2","Teacher2@School.com","011111111");
        admin.addTeacher("2","Teacher 2","Teacher2@School.com","011111111");
        admin.viewAllTeachers();
        admin.removeTeacher("2");
        admin.removeTeacher("3");
        admin.viewAllTeachers();
        admin.viewTeacherDetails("1");
        admin.updateTeacherData("1","Randy","RandyRandy","123");
        admin.viewTeacherDetails("1");

        ////////////Test Student///////////////////
        Student.StudentBuilder builder =new Student.StudentBuilder();
        builder.id("1").name("Student1").age("15");
        Student student = builder.build();
        admin.addStudent(student);

        builder =new Student.StudentBuilder();
        builder.id("2").name("Student2").age("30");
        student = builder.build();
        admin.addStudent(student);
        admin.removeStudent("3");
        admin.viewAllStudents();
        admin.viewStudentDetails("1");
        admin.updateStudentData("1","Randy","RandyRandy","123","13","Masr","Male");
        admin.viewStudentDetails("1");



    }
}