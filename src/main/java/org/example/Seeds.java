package org.example;

public class Seeds {
    public static void seed() throws NotFoundException {
        for(int i=1;i<=3;i++) {
            String id = Integer.toString(i);
            Teacher teacher = new Teacher(id, "Teacher" + id, id + "@yahoo.com", "0123456789" + id);
            Singleton.getSingleton().getTeachers().add(teacher);
        }
        for(int i=1;i<=3;i++)
        {
            String id = Integer.toString(i);
            Course course = new Course(id,"Course"+id);
            Singleton.getSingleton().getCourses().add(course);
        }
        for(int i=1;i<=3;i++)
        {
            String id = Integer.toString(i);
            Student.StudentBuilder builder =new Student.StudentBuilder();
            builder.id(id).name("Student"+id).email(id+"@gmail.com").mobileNumber("0123456789"+id);
            Student student = builder.build();
            Singleton.getSingleton().getStudents().add(student);
            student.enrollCourse(id);
        }


    }
}
