package com.example.springsms.daos;

import com.example.springsms.dto.entities.Course;
import com.example.springsms.dto.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDAO extends JpaRepository<Student,Integer> {
    @Query("select courses from Student where id =:studentId")
    public List<Course> viewEnrolledClasses(int studentId);
}
