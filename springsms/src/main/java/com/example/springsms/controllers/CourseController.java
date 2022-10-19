package com.example.springsms.controllers;

import com.example.springsms.dto.entities.Assignment;
import com.example.springsms.dto.entities.Course;
import com.example.springsms.dto.entities.Student;
import com.example.springsms.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/")
    public List<Course> viewAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable int courseId) {
        return courseService.findById(courseId);
    }

    @PostMapping("/")
    public Course addCourse(@RequestBody Course courseDTO) {
        courseService.save(courseDTO);
        return courseDTO;
    }

    @PutMapping("/")
    public Course updateCourse(@RequestBody Course courseDTO) {
        courseService.save(courseDTO);
        return courseDTO;
    }

    @DeleteMapping("/{courseId}")
    public String removeCourse(@PathVariable int courseId) {
        courseService.deleteById(courseId);
        return "Deleted Course id - " + courseId;
    }

    @GetMapping("/{courseId}/students")
    public List<Student> getStudentsInCourse(@PathVariable int courseId) {
        return courseService.getStudentsInCourse(courseId);
    }

    @GetMapping("/{courseId}/assignments")
    public List<Assignment> getAssignmentsInCourse(@PathVariable int courseId) {

        return courseService.getAssignmentsInCourse(courseId);
    }
    @PostMapping("/{courseId}/{studentId}")
    public void enrollStudentInCourse(@PathVariable int courseId,@PathVariable int studentId) {

         courseService.enrollStudentInCourse(courseId,studentId);
    }
}
