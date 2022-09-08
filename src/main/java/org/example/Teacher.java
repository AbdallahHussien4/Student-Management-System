package org.example;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

public class Teacher {

    private String id;
    private String name;
    private String email;

    private String mobileNumber;

    public Teacher(String id, String name, String email, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public void addAssignment(String id, String description, String courseId, Date dueDate)
    {
        Assignment assignment = new Assignment(id,description,courseId,dueDate);
        HashSet<Course> courses = Singleton.getSingleton().getCourses();
        boolean found=false;
        for(Course course: courses)
        {
            if(course.getId().equals(courseId))
            {
                course.addAssignment(assignment);
                System.out.println("Assignment Added");
                found = true;
            }
        }
        if(!found)
            System.out.println("Course Not Found");
    }

    public void viewStudentsAssignedClasses()
    {
        System.out.println("All Classes' Students: ");
        for(Course course :Singleton.getSingleton().getCourses())
        {
            System.out.println("\tClass "+course.getName());
            for(Student student : course.getStudents())
            {
                System.out.println("\t\t"+student.getName());
            }
        }
    }

    public void getStudentsInCourse(String courseId)
    {
        boolean found= false;
        for(Course course :Singleton.getSingleton().getCourses())
        {
            if(course.getId().equals(courseId)) {
                System.out.print("All Students for ");
                System.out.println("Class " + course.getName());
                found = true;
                for (Student student : course.getStudents()) {
                    System.out.println("\t\t" + student.getName());
                }
            }
        }
        if(!found)
            System.out.println("Course not found");
    }

    public void getAllCourses()
    {
        System.out.println("All Courses: ");
        for(Course course :Singleton.getSingleton().getCourses())
        {
            System.out.println("\t" + course.getName());
        }
    }
    public void getStudentData(String studentID)
    {
        boolean found= false;
        for(Student student :Singleton.getSingleton().getStudents())
        {
            if(student.getId().equals(studentID))
            {
                System.out.println(student);
                found=true;
            }
        }
        if(!found)
            System.out.println("Student not Found");
    }

    public void submitStudentAttendance(String id, String courseId, String studentId, Date attendanceDate, String status)
    {
        CourseAttendance ca = new CourseAttendance(id,courseId,studentId,attendanceDate,status);
        Singleton.getSingleton().getCourseAttendances().add(ca);
        System.out.println("Attendance Submitted");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
