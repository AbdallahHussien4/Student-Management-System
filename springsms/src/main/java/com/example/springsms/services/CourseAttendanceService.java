package com.example.springsms.services;

import com.example.springsms.daos.CourseAttendanceDAO;
import com.example.springsms.dto.entities.CourseAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseAttendanceService {
    private CourseAttendanceDAO courseAttendanceDAO;

    @Autowired
    public CourseAttendanceService(CourseAttendanceDAO courseAttendanceDAO) {
        this.courseAttendanceDAO = courseAttendanceDAO;
    }

    public void save(CourseAttendance courseAttendance) {
        courseAttendanceDAO.save(courseAttendance);
    }

    public void deleteById(int id) {
        courseAttendanceDAO.deleteById(id);
    }

    public List<CourseAttendance> findAll() {
        return courseAttendanceDAO.findAll();
    }

    public CourseAttendance findById(int id) {
        Optional<CourseAttendance> result = courseAttendanceDAO.findById(id);
        return result.orElse(null);
    }
}
