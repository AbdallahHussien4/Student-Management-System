package com.example.springsms.daos;

import com.example.springsms.dto.entities.CourseAttendance;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseAttendanceDAO extends JpaRepository<CourseAttendance,Integer> {
}
