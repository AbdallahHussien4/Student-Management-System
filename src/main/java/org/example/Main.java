package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Admin admin = new Admin("1","Admin 1","Admin@School.com","0123456789");
        Teacher teacher= new Teacher("1","Teacher 1","Teacher1@School.com","011111111");
        admin.addTeacher(teacher);
        teacher= new Teacher("2","Teacher 2","Teacher2@School.com","011111111");
        admin.addTeacher(teacher);
        admin.viewAllTeachers();
//        admin.removeTeacher(teacher);
//        admin.viewAllTeachers();
        admin.viewTeacherDetails(teacher);
    }
}