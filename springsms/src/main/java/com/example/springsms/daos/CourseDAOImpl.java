package com.example.springsms.daos;
import com.example.springsms.dto.entities.Course;
import com.example.springsms.dto.entities.Student;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class CourseDAOImpl {
    @PersistenceContext
    private  EntityManager entityManager;
    public CourseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    public void enrollStudentInCourse( int courseId, int studentId)
    {
        Course course = (Course) entityManager.createQuery("FROM Course c WHERE c.id = :id")
                .setParameter("id", courseId)
                .getSingleResult();
        Student student = (Student) entityManager.createQuery("FROM Student s WHERE s.id = :id")
                .setParameter("id", studentId)
                .getSingleResult();
        System.out.println(student);
        System.out.println(course);
        student.addCourse(course);
        course.addStudent(student);
        Session session = entityManager.unwrap(Session.class);
        session.save(student);
        session.save(course);
    }


}
