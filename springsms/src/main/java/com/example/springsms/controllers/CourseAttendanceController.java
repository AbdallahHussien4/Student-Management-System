package com.example.springsms.controllers;

import com.example.springsms.dto.entities.CourseAttendance;
import com.example.springsms.services.CourseAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseAttendances")
public class CourseAttendanceController {
    private CourseAttendanceService courseAttendanceService;

    @Autowired
    public CourseAttendanceController(CourseAttendanceService courseAttendanceService) {
        this.courseAttendanceService = courseAttendanceService;
    }


    @GetMapping("/")
    public List<CourseAttendance> getAllCourseAttendances() {
        return courseAttendanceService.findAll();
    }

    @GetMapping("/{courseAttendanceId}")
    public CourseAttendance getCourseAttendance(@PathVariable int courseAttendanceId) {
        return courseAttendanceService.findById(courseAttendanceId);
    }

    @PostMapping("/")
    public CourseAttendance addCourseAttendance(@RequestBody CourseAttendance courseAttendance) {
        courseAttendanceService.save(courseAttendance);
        return courseAttendance;
    }

    @PutMapping("/")
    public CourseAttendance updateCourseAttendance(@RequestBody CourseAttendance courseAttendance) {
        courseAttendanceService.save(courseAttendance);
        return courseAttendance;
    }

    @DeleteMapping("/{courseAttendanceId}")
    public String removeCourseAttendance(@PathVariable int courseAttendanceId) {
        courseAttendanceService.deleteById(courseAttendanceId);
        return "Deleted CourseAttendance id - " + courseAttendanceId;
    }


}
