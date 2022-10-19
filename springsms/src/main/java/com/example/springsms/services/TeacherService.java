package com.example.springsms.services;

import com.example.springsms.daos.TeacherDAO;
import com.example.springsms.dto.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private TeacherDAO teacherDAO;

    @Autowired
    public TeacherService(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public void save(Teacher teacher) {
        teacherDAO.save(teacher);
    }

    public void deleteById(int id) {
        teacherDAO.deleteById(id);
    }

    public List<Teacher> findAll() {
        return teacherDAO.findAll();
    }

    public Teacher findById(int id) {
        Optional<Teacher> result = teacherDAO.findById(id);
        return result.orElse(null);
    }

}
