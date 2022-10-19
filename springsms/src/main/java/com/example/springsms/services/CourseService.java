package com.example.springsms.services;

import com.example.springsms.daos.CourseDAO;
//import com.example.springsms.daos.CourseDAOImpl;
import com.example.springsms.daos.CourseDAOImpl;
import com.example.springsms.dto.entities.Assignment;
import com.example.springsms.dto.entities.Course;
import com.example.springsms.dto.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private CourseDAO courseDAO;
    private CourseDAOImpl courseDAOImpl;

    @Autowired
    public CourseService(CourseDAO courseDAO , CourseDAOImpl courseDAOImpl) {

        this.courseDAO = courseDAO;
        this.courseDAOImpl=courseDAOImpl;
    }

    public void save(Course course) {
        courseDAO.save(course);
    }

    public void deleteById(int id) {
        courseDAO.deleteById(id);
    }

    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    public Course findById(int id) {
        Optional<Course> result = courseDAO.findById(id);
        return result.orElse(null);
    }

    public List<Student> getStudentsInCourse(int courseId) {
        return courseDAO.getStudentsInCourse(courseId);
    }

    public List<Assignment> getAssignmentsInCourse(int courseId) {
        return courseDAO.getAssignmentsInCourse(courseId);
    }
    public void enrollStudentInCourse(int courseId,int studentId)
    {
        courseDAOImpl.enrollStudentInCourse( courseId, studentId);
    }
}
