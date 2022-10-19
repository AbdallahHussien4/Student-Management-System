package com.example.springsms.dto.entities;

import com.example.springsms.dto.AssignmentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="assignment_ID")
    Integer id;
    @Column(name="description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    @JsonIgnore
    @OneToMany(mappedBy = "assignment")
    private List<AssignmentSubmission> assignmentSubmissions;

    public Assignment() {
    }

    public Assignment(Integer id, String description, Course course, List<AssignmentSubmission> assignmentSubmissions) {
        this.id = id;
        this.description = description;
        this.course = course;
        this.assignmentSubmissions = assignmentSubmissions;
    }

    public Assignment(AssignmentDTO assignmentDTO) {
        this.id = assignmentDTO.getId();
        this.description = assignmentDTO.getDescription();
        this.course = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<AssignmentSubmission> getAssignmentSubmissions() {
        return assignmentSubmissions;
    }

    public void setAssignmentSubmissions(List<AssignmentSubmission> assignmentSubmissions) {
        this.assignmentSubmissions = assignmentSubmissions;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", course=" + course +
                ", assignmentSubmissions=" + assignmentSubmissions +
                '}';
    }
}
