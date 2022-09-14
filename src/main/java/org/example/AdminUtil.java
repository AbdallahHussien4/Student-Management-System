package org.example;

import java.util.Scanner;

public class AdminUtil {

    public static void print(String words )
    {
        System.out.println(words);
    }
    public static void welcomeAdmin()
    {
        // TODO : Clear Screen Option.
        print("////////////// Welcome Admin /////////////");
        print("Choose a function :");
        print("\t 1: Add Teacher");
        print("\t 2: Remove Teacher");
        print("\t 3: View All Teachers");
        print("\t 4: View Teacher Details");
        print("\t 5: Update Teacher Data");
        print("\t 6: Add Student");
        print("\t 7: Remove Student");
        print("\t 8: View All Students");
        print("\t 9: View Student Details");
        print("\t 10: Update Student Data ");
        print("\t 0: Log Out");
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
