package org.example;

import java.text.ParseException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void print(String words )
    {
        System.out.println(words);
    }

    public static void welcomeGeneral()
    {
        print("////////////// Welcome /////////////");
        print("Please Enter Your Role Number:");
        print("\t 1: Admin");
        print("\t 2: Teacher");
        print("\t 3: Student");
        print("\t 0: Exit");
    }

    public static void main(String[] args) throws ParseException, InterruptedException {
        Seeds.seed();
        boolean exit = false;
        // TODO : User & UserUtil Interfaces.
        // TODO : Strategy Design Pattern
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
                        TimeUnit.SECONDS.sleep(2);
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
                        TimeUnit.SECONDS.sleep(2);
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
                        TimeUnit.SECONDS.sleep(2);
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