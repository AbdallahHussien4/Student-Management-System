package com.example.springsms.controllers;

import com.example.springsms.dto.AssignmentDTO;
import com.example.springsms.facade.AssignmentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
    private AssignmentFacade assignmentFacade;

    @Autowired
    public AssignmentController(AssignmentFacade assignmentFacade) {
        this.assignmentFacade = assignmentFacade;
    }


    @GetMapping("/")
    public List<AssignmentDTO> getAllAssignments() {
        return assignmentFacade.findAll();
    }

    @GetMapping("/{assignmentId}")
    public AssignmentDTO getAssignment(@PathVariable int assignmentId) {
        return assignmentFacade.findById(assignmentId);
    }

    @PostMapping("/")
    public AssignmentDTO addAssignment(@RequestBody AssignmentDTO assignment) {
        assignmentFacade.add(assignment);
        return assignment;
    }

    @PutMapping("/")
    public AssignmentDTO updateAssignment(@RequestBody AssignmentDTO assignment) {
        assignmentFacade.update(assignment);
        return assignment;
    }

    @DeleteMapping("/{assignmentId}")
    public String removeAssignment(@PathVariable int assignmentId) {
        assignmentFacade.deleteById(assignmentId);
        return "Deleted Assignment id - " + assignmentId;
    }
}
