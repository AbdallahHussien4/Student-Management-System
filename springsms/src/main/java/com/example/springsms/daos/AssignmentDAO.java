package com.example.springsms.daos;

import com.example.springsms.dto.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AssignmentDAO extends JpaRepository<Assignment,Integer> {
}
