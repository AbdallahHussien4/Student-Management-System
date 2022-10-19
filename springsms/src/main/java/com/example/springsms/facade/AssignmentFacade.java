package com.example.springsms.facade;

import com.example.springsms.dto.AssignmentDTO;
import com.example.springsms.dto.entities.Assignment;
import com.example.springsms.dto.entities.Course;
import com.example.springsms.services.AssignmentService;
import com.example.springsms.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentFacade {
    private AssignmentService assignmentService;
    private CourseService courseService;

    @Autowired
    public AssignmentFacade(AssignmentService assignmentService, CourseService courseService) {
        this.assignmentService = assignmentService;
        this.courseService = courseService;
    }


    public void add(AssignmentDTO assignmentDTO) {
        Assignment assignment = convertToEntity(assignmentDTO);
        assignment.setId(0);
        assignmentService.save(assignment);
        assignmentDTO.setId(assignment.getId());
    }

    public void update(AssignmentDTO assignmentDTO) {

        Assignment dbAssignment = assignmentService.findById(assignmentDTO.getId());
        Assignment assignment = convertToEntity(assignmentDTO);
        assignmentService.save(assignment);
    }

    public void deleteById(int id) {
        Assignment assignment = assignmentService.findById(id);

        assignmentService.deleteById(id);
    }

    public List<AssignmentDTO> findAll() {
        return assignmentService.findAll().stream().map(AssignmentDTO::new)
                .collect(Collectors.toList());
    }

    public AssignmentDTO findById(int id) {
        Assignment assignment = assignmentService.findById(id);

        return new AssignmentDTO(assignment);
    }

    private Assignment convertToEntity(AssignmentDTO assignmentDTO) {

        Course course = courseService.findById(assignmentDTO.getCourseId());
        Assignment assignment = new Assignment(assignmentDTO);
        assignment.setCourse(course);

        return assignment;
    }
}
