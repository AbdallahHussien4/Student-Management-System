package com.example.springsms.services;

import com.example.springsms.daos.AssignmentDAO;
import com.example.springsms.dto.entities.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    private AssignmentDAO assignmentDAO;

    @Autowired
    public AssignmentService(AssignmentDAO assignmentDAO) {
        this.assignmentDAO = assignmentDAO;
    }

    public void save(Assignment assignment) {

        assignmentDAO.save(assignment);
    }

    public void deleteById(int id) {
        assignmentDAO.deleteById(id);
    }

    public List<Assignment> findAll() {
        return assignmentDAO.findAll();
    }

    public Assignment findById(int id) {
        Optional<Assignment> result = assignmentDAO.findById(id);
        return result.orElse(null);
    }
}
