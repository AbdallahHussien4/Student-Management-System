package com.example.springsms.dto.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "assignmentSubmissions")
public class AssignmentSubmission {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    Integer id;
    @Column(name="content")
    private String content;
    
    @Column(name="due_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name="assignment_id")
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    public AssignmentSubmission() {
    }

    public AssignmentSubmission(Integer id, String content, String grades, Date date, Student student, Assignment assignment) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.student = student;
        this.assignment = assignment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    @Override
    public String toString() {
        return "AssignmentSubmission{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", student=" + student +
                ", assignment=" + assignment +
                '}';
    }
}
