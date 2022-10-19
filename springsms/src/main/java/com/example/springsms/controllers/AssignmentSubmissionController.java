package com.example.springsms.controllers;

import com.example.springsms.dto.entities.AssignmentSubmission;
import com.example.springsms.services.AssignmentSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignmentSubmissions")
public class AssignmentSubmissionController {
    private AssignmentSubmissionService assignmentSubmissionService;

    @Autowired
    public AssignmentSubmissionController(AssignmentSubmissionService assignmentSubmissionService) {
        this.assignmentSubmissionService = assignmentSubmissionService;
    }


    @GetMapping("/")
    public List<AssignmentSubmission> getAllAssignmentSubmissions() {
        return assignmentSubmissionService.findAll();
    }

    @GetMapping("/{assignmentSubmissionId}")
    public AssignmentSubmission getAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
        return assignmentSubmissionService.findById(assignmentSubmissionId);
    }

    @PostMapping("/")
    public AssignmentSubmission addAssignmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission) {
        assignmentSubmissionService.save(assignmentSubmission);
        return assignmentSubmission;
    }

    @PutMapping("/")
    public AssignmentSubmission updateAssignmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission) {
        assignmentSubmissionService.save(assignmentSubmission);
        return assignmentSubmission;
    }

    @DeleteMapping("/{assignmentSubmissionId}")
    public String removeAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
        assignmentSubmissionService.deleteById(assignmentSubmissionId);
        return "Deleted AssignmentSubmission id - " + assignmentSubmissionId;
    }
}
