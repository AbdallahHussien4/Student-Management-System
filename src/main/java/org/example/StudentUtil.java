package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StudentUtil {
    public static void print(String words )
    {
        System.out.println(words);
    }

    public static void welcomeStudent()
    {
        print("////////////// Welcome Teacher /////////////");
        print("Choose a function :");
        print("\t View Enrolled Courses : 1");
        print("\t View Assignments : 2");
        print("\t Submit Assignment : 3");
        print("\t Enroll Course : 4");
        print("\t Log Out : 0");
    }

    public static boolean handleStudentLogic(Student student,String function) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        switch (function) {
            case ("0"):
                return true;
            case ("1"):
                print("////////////// Viewing All Enrolled Courses /////////////");
                student.viewEnrollCourses();
                break;
            case ("2"):
                print("////////////// Viewing All Assignments /////////////");
                print("Enter The Course's ID");
                String id = scanner.nextLine();
                student.viewAssignments(id);
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
                Date SubmissionDate = new SimpleDateFormat("dd/mm/yyyy").parse(date);
                print("\tSubmission Content: ");
                String content = scanner.nextLine();
                print("\tMarks: ");
                float marks = scanner.nextFloat();
                student.submitAssignment(id,courseId,SubmissionDate,content,marks);
                break;
            case("4"):
                print("////////////// Enrolling in a Course /////////////");
                print("Enter The Course's ID");
                id = scanner.nextLine();
                student.enrollCourse(id);
                break;
        }
        return false;
    }
}
