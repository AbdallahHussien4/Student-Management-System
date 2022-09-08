package org.example;

import java.util.Scanner;

public class AdminUtil {

    public static void print(String words )
    {
        System.out.println(words);
    }
    public static void welcomeAdmin()
    {
        print("////////////// Welcome Admin /////////////");
        print("Choose a function :");
        print("\t Add Teacher : 1");
        print("\t Remove Teacher : 2");
        print("\t View All Teachers : 3");
        print("\t View Teacher Details : 4");
        print("\t Update Teacher Data : 5");
        print("\t Add Student : 6");
        print("\t Remove Student : 7");
        print("\t View All Students : 8");
        print("\t View Student Details : 9");
        print("\t Update Student Data : 10");
        print("\t Log Out : 0");
    }

    public static boolean  handelAdminLogic(Admin admin,String function)
    {

        Scanner scanner = new Scanner(System.in);
        switch (function) {
            case ("0"):
                return true;
            case ("1"):
                print("////////////// Adding Teacher /////////////");
                print("Enter The Following Information:");
                print("\tTeacher ID: ");
                String id = scanner.nextLine();
                print("\tTeacher Name: ");
                String name = scanner.nextLine();
                print("\tTeacher Email: ");
                String email = scanner.nextLine();
                print("\tTeacher Mobile Number: ");
                String mobileNumber = scanner.nextLine();
                admin.addTeacher(id, name, email, mobileNumber);
                break;
            case ("2"):
                print("////////////// Removing Teacher /////////////");
                print("Enter The Teacher's ID");
                id = scanner.nextLine();
                admin.removeTeacher(id);
                break;
            case ("3"):
                print("////////////// Viewing All Teachers /////////////");
                admin.viewAllTeachers();
                break;
            case ("4"):
                print("////////////// Viewing Teacher's Details /////////////");
                print("Enter The Teacher's ID");
                id = scanner.nextLine();
                admin.viewTeacherDetails(id);
                break;
            case ("5"):
                print("////////////// Updating Teacher's Data /////////////");
                print("Enter The Following Information:");
                print("\tTeacher Old ID: ");
                id = scanner.nextLine();
                print("\tTeacher New Name: ");
                name = scanner.nextLine();
                print("\tTeacher New Email: ");
                email = scanner.nextLine();
                print("\tTeacher New Mobile Number: ");
                mobileNumber = scanner.nextLine();
                admin.updateTeacherData(id, name, email, mobileNumber);
                break;
            case ("6"):
                print("////////////// Adding Student /////////////");
                print("Enter The Following Information:");
                print("\tStudent ID: ");
                id = scanner.nextLine();
                print("\tStudent Name: ");
                name = scanner.nextLine();
                print("\tStudent Email: ");
                email = scanner.nextLine();
                print("\tStudent Mobile Number: ");
                mobileNumber = scanner.nextLine();
                print("\tStudent Age: ");
                String age = scanner.nextLine();
                print("\tStudent Gender: ");
                String gender = scanner.nextLine();
                print("\tStudent Address: ");
                String address = scanner.nextLine();
                Student.StudentBuilder builder =new Student.StudentBuilder();
                builder.id(id).name(name).age(age).address(address).gender(gender).email(email).mobileNumber(mobileNumber);
                Student student = builder.build();
                admin.addStudent(student);
                break;
            case ("7"):
                print("////////////// Removing Student /////////////");
                print("Enter The Student's ID");
                id = scanner.nextLine();
                admin.removeStudent(id);
                break;
            case ("8"):
                print("////////////// Viewing All Students /////////////");
                admin.viewAllStudents();
                break;
            case ("9"):
                print("////////////// Viewing Student's Details /////////////");
                print("Enter The Student's ID");
                id = scanner.nextLine();
                print(id);
                admin.viewStudentDetails(id);
                break;
            case ("10"):
                print("////////////// Updating Student's Data /////////////");
                print("Enter The Following Information:");
                print("\tTeacher Old ID: ");
                id = scanner.nextLine();
                print("\tTeacher New Name: ");
                name = scanner.nextLine();
                print("\tTeacher New Email: ");
                email = scanner.nextLine();
                print("\tTeacher New Mobile Number: ");
                mobileNumber = scanner.nextLine();
                print("\tStudent Age: ");
                age = scanner.nextLine();
                print("\tStudent Gender: ");
                gender = scanner.nextLine();
                print("\tStudent Address: ");
                address = scanner.nextLine();
                admin.updateStudentData(id, name, email, mobileNumber,age,address,gender);
                break;
        }
        return false;
    }
}
