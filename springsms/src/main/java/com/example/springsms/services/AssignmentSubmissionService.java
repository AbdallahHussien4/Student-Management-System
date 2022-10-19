package com.example.springsms.services;

import com.example.springsms.daos.AssignmentSubmissionDAO;
import com.example.springsms.dto.entities.AssignmentSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentSubmissionService {
    private AssignmentSubmissionDAO assignmentSubmissionDAO;

    @Autowired
    public AssignmentSubmissionService(AssignmentSubmissionDAO assignmentSubmissionDAO) {
        this.assignmentSubmissionDAO = assignmentSubmissionDAO;
    }

    public void save(AssignmentSubmission assignmentSubmission) {
        assignmentSubmissionDAO.save(assignmentSubmission);
    }

    public void deleteById(int id) {
        assignmentSubmissionDAO.deleteById(id);
    }

    public List<AssignmentSubmission> findAll() {
        return assignmentSubmissionDAO.findAll();
    }

    public AssignmentSubmission findById(int id) {
        Optional<AssignmentSubmission> result = assignmentSubmissionDAO.findById(id);
        return result.orElse(null);
    }
}
