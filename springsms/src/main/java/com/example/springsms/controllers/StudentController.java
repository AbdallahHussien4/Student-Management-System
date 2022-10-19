package com.example.springsms.controllers;


import com.example.springsms.dto.entities.Course;
import com.example.springsms.dto.entities.Student;
import com.example.springsms.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);

        if(student == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        return student;
    }

    @PostMapping("/")
    public Student addStudent(@RequestBody Student student) {

        student.setId(0);

        studentService.save(student);

        return student;
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable int studentId, @RequestBody Student student) {
        Student dbStudent = studentService.findById(studentId);

        if(dbStudent == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        student.setId(studentId);
        studentService.save(student);
        return student;
    }

    @DeleteMapping("/{studentId}")
    public String removeStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);

        if(student == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        studentService.deleteById(studentId);

        return "Deleted Student id - " + studentId;
    }


    @GetMapping("/{studentId}/courses")
    public List<Course> viewEnrolledClasses(@PathVariable int studentId) {
        return studentService.viewEnrolledClasses(studentId);
    }

}
