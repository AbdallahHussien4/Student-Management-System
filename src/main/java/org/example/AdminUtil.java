package org.example;

import java.util.Scanner;

public class AdminUtil implements UserUtilInterface {

    public static void print(String words )
    {
        System.out.println(words);
    }

    @Override
    public void welcome() {
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

    @Override
    public boolean handleLogic(User user, String function) throws NotFoundException {
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
                ((Admin)user).addTeacher(id, name, email, mobileNumber);
                break;
            case ("2"):
                print("////////////// Removing Teacher /////////////");
                print("Enter The Teacher's ID");
                id = scanner.nextLine();
                ((Admin)user).removeTeacher(id);
                break;
            case ("3"):
                print("////////////// Viewing All Teachers /////////////");
                ((Admin)user).viewAllTeachers();
                break;
            case ("4"):
                print("////////////// Viewing Teacher's Details /////////////");
                print("Enter The Teacher's ID");
                id = scanner.nextLine();
                ((Admin)user).viewTeacherDetails(id);
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
                ((Admin)user).updateTeacherData(id, name, email, mobileNumber);
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
                ((Admin)user).addStudent(student);
                break;
            case ("7"):
                print("////////////// Removing Student /////////////");
                print("Enter The Student's ID");
                id = scanner.nextLine();
                ((Admin)user).removeStudent(id);
                break;
            case ("8"):
                print("////////////// Viewing All Students /////////////");
                ((Admin)user).viewAllStudents();
                break;
            case ("9"):
                print("////////////// Viewing Student's Details /////////////");
                print("Enter The Student's ID");
                id = scanner.nextLine();
                print(id);
                ((Admin)user).viewStudentDetails(id);
                break;
            case ("10"):
                print("////////////// Updating Student's Data /////////////");
                print("Enter The Following Information:");
                print("\tStudent Old ID: ");
                id = scanner.nextLine();
                print("\tStudent New Name: ");
                name = scanner.nextLine();
                print("\tStudent New Email: ");
                email = scanner.nextLine();
                print("\tStudent New Mobile Number: ");
                mobileNumber = scanner.nextLine();
                print("\tStudent Age: ");
                age = scanner.nextLine();
                print("\tStudent Gender: ");
                gender = scanner.nextLine();
                print("\tStudent Address: ");
                address = scanner.nextLine();
                ((Admin)user).updateStudentData(id, name, email, mobileNumber,age,address,gender);
                break;
        }
        return false;
    }
    
}
