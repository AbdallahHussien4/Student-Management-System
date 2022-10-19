package com.example.springsms.dto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="course_id")
    Integer id;
    @Column(name="name")
    private String name;

    @JsonIgnore
    @ManyToMany (mappedBy = "courses", fetch = FetchType.LAZY)
    private List<Student> students;
    @JsonIgnore
    @OneToMany(mappedBy = "course",fetch=FetchType.LAZY )
    private List<Assignment> assignments;
    @JsonIgnore
    @OneToMany(mappedBy = "course",fetch=FetchType.LAZY)
    private List<CourseAttendance> courseAttendances;
    public Course() {
    }


    public Course(String name) {
        this.name = name;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<CourseAttendance> getCourseAttendances() {
        return courseAttendances;
    }

    public void setCourseAttendances(List<CourseAttendance> courseAttendances) {
        this.courseAttendances = courseAttendances;
    }
    public void addStudent(Student student)
    {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
