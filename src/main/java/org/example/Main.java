package org.example;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void print(String words )
    {
        System.out.println(words);
    }

    public static void welcomeGeneral()
    {
        print("////////////// Welcome /////////////");
        print("Please Enter Your Role Number:");
        print("\t Admin : 1");
        print("\t Teacher : 2");
        print("\t Student : 3");
        print("\t Exit : 0");
    }

    public static void main(String[] args) throws ParseException {
        Seeds.seed();
        boolean exit = false;
        while(true && !exit)
        {
            welcomeGeneral();
            Scanner scanner = new Scanner(System.in);
            String role = scanner.nextLine();
            switch (role) {
                case ("1"):
                    Admin admin = new Admin("0","Admin1","Admin1@School.com","0123456789");
                    boolean exitAdmin = false;
                    while(true && !exitAdmin)
                    {
                        AdminUtil.welcomeAdmin();
                        String function = scanner.nextLine();
                        exitAdmin = AdminUtil.handelAdminLogic(admin,function);
                    }
                    break;
                case ("2"):
                    Teacher teacher = new Teacher("0","Teacher0","Teacher0@School.com","01234567891");
                    boolean exitTeacher = false;
                    while(true && !exitTeacher)
                    {
                        TeacherUtil.welcomeTeacher();
                        String function = scanner.nextLine();
                        exitTeacher = TeacherUtil.handelTeacherLogic(teacher,function);
                    }
                    break;
                case ("3"):
                    Student.StudentBuilder builder = new Student.StudentBuilder();
                    builder.id("0").name("Student0");
                    builder.build();
                    Student student=new Student(builder);
                    boolean exitStudent = false;
                    while(true && !exitStudent)
                    {
                        StudentUtil.welcomeStudent();
                        String function = scanner.nextLine();
                        exitStudent = StudentUtil.handleStudentLogic(student,function);
                    }
                    break;
                case ("0"):
                    exit = true;
                    break;
                default:
                    print("Please Enter Valid Role");
                    break;
            }
        }
    }
}