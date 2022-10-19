package com.example.springsms.services;

import com.example.springsms.daos.StudentDAO;
import com.example.springsms.dto.entities.Course;
import com.example.springsms.dto.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void save(Student student) {
        studentDAO.save(student);
    }

    public void deleteById(int id) {
        studentDAO.deleteById(id);
    }

    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    public Student findById(int id) {
        Optional<Student> result = studentDAO.findById(id);
        return result.orElse(null);
    }

    public List<Course> viewEnrolledClasses(int id) {
        return studentDAO.viewEnrolledClasses(id);
    }

}
