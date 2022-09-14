package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StudentUtil implements UserUtilInterface{
    public static void print(String words )
    {
        System.out.println(words);
    }

    @Override
    public void welcome() {
        print("////////////// Welcome Teacher /////////////");
        print("Choose a function :");
        print("\t 1: View Enrolled Courses ");
        print("\t 2: View Assignments ");
        print("\t 3: Submit Assignment ");
        print("\t 4: Enroll Course ");
        print("\t 0: Log Out ");
    }

    @Override
    public boolean handleLogic(User user, String function) {
        Scanner scanner = new Scanner(System.in);
        switch (function) {
            case ("0"):
                return true;
            case ("1"):
                print("////////////// Viewing All Enrolled Courses /////////////");
                ((Student)user).viewEnrollCourses();
                break;
            case ("2"):
                print("////////////// Viewing All Assignments /////////////");
                print("Enter The Course's ID");
                String id = scanner.nextLine();
                ((Student)user).viewAssignments(id);
                break;
            case ("3"):
                print("////////////// Submit Assignment /////////////");
                print("Enter The Following Information:");
                print("\tAssignment ID: ");
                id = scanner.nextLine();
                print("\tCourse ID: ");
                String courseId = scanner.nextLine();
                print("\tSubmission Date On Format dd/mm/yyyy: ");
                String date = scanner.nextLine();
                Date SubmissionDate = null;
                try {
                    SubmissionDate = new SimpleDateFormat("dd/mm/yyyy").parse(date);
                } catch (ParseException e) {
                    System.out.println("Please Enter Date iin the following format dd/mm/yyyy");
                    return  false;
                }
                print("\tSubmission Content: ");
                String content = scanner.nextLine();
                print("\tMarks: ");
                float marks = scanner.nextFloat();
                ((Student)user).submitAssignment(id,courseId,SubmissionDate,content,marks);
                break;
            case("4"):
                print("////////////// Enrolling in a Course /////////////");
                print("Enter The Course's ID");
                id = scanner.nextLine();
                ((Student)user).enrollCourse(id);
                break;
        }
        return false;
    }
    
}
