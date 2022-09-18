package org.example;

import java.util.HashSet;

public class Course {
    private String id;
    private String name;
    private HashSet<Student> students;



    private HashSet<Assignment> assignments;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
        this.students = new HashSet<Student>();
        this.assignments = new HashSet<Assignment>();
    }
    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
//                ", students=" + students +
                ", assignments=" + assignments +
                '}';
    }
    public void addAssignment(Assignment assignment)
    {
        this.assignments.add(assignment);
    }
    public HashSet<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(HashSet<Assignment> assignments) {
        this.assignments = assignments;
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public void setStudents(HashSet<Student> students) {
        this.students = students;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
