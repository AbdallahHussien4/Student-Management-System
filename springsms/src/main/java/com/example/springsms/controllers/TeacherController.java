package com.example.springsms.controllers;

import com.example.springsms.dto.entities.Teacher;
import com.example.springsms.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping("/")
    public List<Teacher> viewAllTeachers() {
        return teacherService.findAll();
    }

    @GetMapping("/{teacherId}")
    public Teacher getTeacher(@PathVariable int teacherId) {
        Teacher teacher = teacherService.findById(teacherId);

        if(teacher == null) {
            throw new RuntimeException("Teacher id not found - " + teacherId);
        }

        return teacher;
    }

    @PostMapping("/")
    public Teacher addTeacher(@RequestBody Teacher teacher) {

        teacher.setId(0);

        teacherService.save(teacher);

        return teacher;
    }

    @PutMapping("/{teacherId}")
    public Teacher updateTeacher(@PathVariable int teacherId, @RequestBody Teacher teacher) {
        Teacher dbTeacher = teacherService.findById(teacherId);

        if(dbTeacher == null) {
            throw new RuntimeException("Teacher id not found - " + teacherId);
        }

        teacher.setId(teacherId);
        teacherService.save(teacher);
        return teacher;
    }

    @DeleteMapping("/{teacherId}")
    public String removeTeacher(@PathVariable int teacherId) {
        Teacher teacher = teacherService.findById(teacherId);

        if(teacher == null) {
            throw new RuntimeException("Teacher id not found - " + teacherId);
        }

        teacherService.deleteById(teacherId);

        return "Deleted Teacher id - " + teacherId;
    }


}
