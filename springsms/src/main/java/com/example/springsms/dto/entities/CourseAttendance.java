package com.example.springsms.dto.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="courseAttendances")
public class CourseAttendance {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    Integer id;
    @Column(name="date")
    Date date;
    @Column(name="status")
    String status;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    public CourseAttendance() {
    }

    public CourseAttendance(Integer id, Date date, String status, Student student, Course course) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.student = student;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseAttendance{" +
                "id=" + id +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
