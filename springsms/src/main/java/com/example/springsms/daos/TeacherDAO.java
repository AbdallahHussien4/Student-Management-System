package com.example.springsms.daos;

import com.example.springsms.dto.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeacherDAO extends JpaRepository<Teacher,Integer> {
}
