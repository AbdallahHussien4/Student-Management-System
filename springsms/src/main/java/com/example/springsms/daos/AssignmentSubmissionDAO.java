package com.example.springsms.daos;

import com.example.springsms.dto.entities.AssignmentSubmission;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AssignmentSubmissionDAO extends JpaRepository<AssignmentSubmission,Integer> {
}
