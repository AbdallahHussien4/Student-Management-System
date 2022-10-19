package com.example.springsms.dto;

import com.example.springsms.dto.entities.Assignment;

public class AssignmentDTO {
    private int id;

    private String description;

    private int courseId;


    public AssignmentDTO() {
    }

    public AssignmentDTO(Assignment assignment) {
        this.id = assignment.getId();
        this.description = assignment.getDescription();
        this.courseId = assignment.getCourse().getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }



}
