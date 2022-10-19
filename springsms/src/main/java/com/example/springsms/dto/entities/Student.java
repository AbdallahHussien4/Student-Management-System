package com.example.springsms.dto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student_ID")
    Integer id;
    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "mobileNumber")
    private String mobileNumber;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "courses_students", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<AssignmentSubmission> assignmentSubmissions;
    
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<CourseAttendance> courseAttendances;

    public Student() {
    }

    public Student(String name, String email, String mobileNumber, String age, String address, String gender) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<AssignmentSubmission> getAssignmentSubmissions() {
        return assignmentSubmissions;
    }

    public void setAssignmentSubmissions(List<AssignmentSubmission> assignmentSubmissions) {
        this.assignmentSubmissions = assignmentSubmissions;
    }

    public List<CourseAttendance> getCourseAttendances() {
        return courseAttendances;
    }

    public void setCourseAttendances(List<CourseAttendance> courseAttendances) {
        this.courseAttendances = courseAttendances;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
               
                '}';
    }
}
