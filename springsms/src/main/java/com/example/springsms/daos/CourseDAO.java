package com.example.springsms.daos;

import com.example.springsms.dto.entities.Assignment;
import com.example.springsms.dto.entities.Course;
import com.example.springsms.dto.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CourseDAO extends JpaRepository<Course, Integer> {
    @Query(value="select c.students from Course c where c.id =:courseId")
    List<Student> getStudentsInCourse(int courseId);

    @Query(value="select c.assignments from Course c where c.id =:courseId")
    List<Assignment> getAssignmentsInCourse(int courseId);
}
