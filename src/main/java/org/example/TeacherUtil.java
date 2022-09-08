package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TeacherUtil {
    public static void print(String words )
    {
        System.out.println(words);
    }

    public static void welcomeTeacher()
    {
        print("////////////// Welcome Teacher /////////////");
        print("Choose a function :");
        print("\t View All Students in All Courses : 1");
        print("\t View Student in One Course : 2");
        print("\t View All Courses : 3");
        print("\t View Students Data : 4");
        print("\t Add Assignment : 5");
        print("\t Submit Attendance : 6");
        print("\t Log Out : 0");
    }

    public static boolean  handelTeacherLogic(Teacher teacher,String function) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        switch (function) {
            case ("0"):
                return true;
            case ("1"):
                print("////////////// Viewing All Students /////////////");
                teacher.viewStudentsAssignedClasses();
                break;
            case ("2"):
                print("////////////// Viewing in One Course /////////////");
                print("Enter The Course's ID");
                String id = scanner.nextLine();
                teacher.getStudentsInCourse(id);
                break;
            case ("3"):
                print("////////////// Viewing All Courses /////////////");
                teacher.getAllCourses();
                break;
            case ("4"):
                print("////////////// Viewing Student's Data /////////////");
                print("Enter The Student's ID");
                id = scanner.nextLine();
                teacher.getStudentData(id);
                break;
            case ("5"):
                print("////////////// Adding Assignment /////////////");
                print("Enter The Following Information:");
                print("\tAssignment ID: ");
                id = scanner.nextLine();
                print("\tAssignment Description: ");
                String description = scanner.nextLine();
                print("\tCourse ID: ");
                String courseId = scanner.nextLine();
                print("\tDue Date On Format dd/mm/yyyy: ");
                String date = scanner.nextLine();
                Date dueDate = new SimpleDateFormat("dd/mm/yyyy").parse(date);
                teacher.addAssignment(id, description, courseId, dueDate);
                break;
            case ("6"):
                print("////////////// Submitting Attendance /////////////");
                print("Enter The Following Information:");
                print("\tAttendance ID: ");
                id = scanner.nextLine();
                print("\tStudent ID: ");
                String studentId = scanner.nextLine();
                print("\tCourse ID: ");
                courseId = scanner.nextLine();
                print("\tAttendance Date On Format dd/mm/yyyy: ");
                date = scanner.nextLine();
                Date attendanceDate = new SimpleDateFormat("dd/mm/yyyy").parse(date);
                print("\tStatus: ");
                String status = scanner.nextLine();
                teacher.submitStudentAttendance(id,courseId,studentId,attendanceDate,status);
                break;
        }
        return false;
    }
}
