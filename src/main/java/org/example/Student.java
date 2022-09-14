package org.example;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

public class Student extends User{

    public  static class StudentBuilder{
        private String id;
        private String name;
        private String email;
        private String mobileNumber;
        private String age;
        private String address;
        private String gender;

        public StudentBuilder(){}
        public Student build(){
            return new Student(this);
        }

        public StudentBuilder id(String id)
        {
            this.id=id;
            return this;
        }
        public StudentBuilder name(String name)
        {
            this.name=name;
            return this;
        }
        public StudentBuilder email(String email)
        {
            this.email=email;
            return this;
        }
        public StudentBuilder mobileNumber(String mobileNumber)
        {
            this.mobileNumber=mobileNumber;
            return this;
        }
        public StudentBuilder age(String age)
        {
            this.age=age;
            return this;
        }
        public StudentBuilder address(String address)
        {
            this.address=address;
            return this;
        }
        public StudentBuilder gender(String gender)
        {
            this.gender=gender;
            return this;
        }
    }
    private String age;
    private String address;
    private String gender;
    private HashSet<Course> courses;

    public Student(StudentBuilder builder) {
        super(builder.id,builder.name,builder.email,builder.mobileNumber);
        this.age = builder.age;
        this.address = builder.address;
        this.gender = builder.gender;
        this.courses = new HashSet<Course>();
    }
    public void enrollCourse(String courseID)
    {
        HashSet<Course> courses = Singleton.getSingleton().getCourses();
        boolean found = false;
        for (Course course : courses) {

            if(course.getId().equals(courseID))
            {
                course.getStudents().add(this);
                this.courses.add(course);
                found = true;
                System.out.println("Student Enrolled");
            }
        }
        if(!found)
            System.out.println("Course not found");
    }

    public void viewEnrollCourses()
    {
        if(this.courses.isEmpty())
        {
            System.out.println("Student is not enrolled in any courses");
            return;
        }
        System.out.println("Enrolled Courses: ");

        for(Course course: this.courses)
        {
            System.out.println(course.getName());
        }
    }
    public void viewAssignments(String courseId)
    {
        boolean found=false;
        for(Course course:Singleton.getSingleton().getCourses())
        {
            if(course.getId().equals(courseId))
            {
                System.out.println("List of Assignments");
                found = true;
                for(Assignment assignment: course.getAssignments())
                {
                    System.out.println(assignment.getId());
                }
            }
        }
        if(!found)
            System.out.println("Course Not Found");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", mobileNumber='" + getMobileNumber() + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", courses=" + courses +
                '}';
    }

    public void submitAssignment(String assignmentId, String courseId, Date submissionDate, String assignmentContentSubmitted, float assignmentMarks)
    {
        AssignmentSubmission as = new AssignmentSubmission(assignmentId,getId(),courseId,submissionDate,assignmentContentSubmitted,assignmentMarks);
        Singleton.getSingleton().getAssignmentSubmissions().add(as);
        System.out.println("Assignment Submitted");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return this.getId().equals(student.getId()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
