package org.example;

import java.util.HashSet;

public class Admin extends User{


    public Admin(String id, String name, String email, String mobileNumber) {
        super(id,name,email,mobileNumber);
    }

    //////////// Manage Teachers Functions ////////////
    void addTeacher(String id, String name, String email, String number) throws NotFoundException {
        Main.logger.info("Adding New Teacher...");
        Teacher teacher = new Teacher(id,name,email,number);
        HashSet<Teacher> teachers = Singleton.getSingleton().getTeachers();
        if(teachers.contains(teacher))
        {
            throw (new NotFoundException(String.format("Teacher with ID: %s already exists.",id)));
        }
        Main.logger.info(String.format("Teacher %s added successfully",name));
        teachers.add(teacher);
    }
    void removeTeacher(String id) throws NotFoundException {
        Main.logger.info(String.format("Removing teacher with ID: %s",id));
        HashSet<Teacher> teachers = Singleton.getSingleton().getTeachers();
        for (Teacher teacher : teachers) {
            if(teacher.getId().equals(id))
            {
                teachers.remove(teacher);
                Main.logger.info("Teacher Removed Successfully");
                return;
            }
        }
        throw(new NotFoundException(String.format("Teacher with ID: %s not found.",id)));

    }
    void viewAllTeachers()
    {
        System.out.println("List Of All Teachers :");

        for(Teacher t : Singleton.getSingleton().getTeachers())
        {
            System.out.println("\t"+t);
        }
    }
    void viewTeacherDetails(String id) throws NotFoundException {
        HashSet<Teacher> teachers = Singleton.getSingleton().getTeachers();
        for (Teacher teacher : teachers) {
            if(teacher.getId().equals(id))
            {
                System.out.println(teacher);
                return;
            }
        }
        throw(new NotFoundException(String.format("Teacher with ID: %s not found.",id)));

    }
    void updateTeacherData(String id, String name, String email, String mobileNumber) throws NotFoundException {
        HashSet<Teacher> teachers = Singleton.getSingleton().getTeachers();
        for (Teacher teacher : teachers) {
            if(teacher.getId().equals(id))
            {
                if(name!="")
                    teacher.setName(name);
                if(email!="")
                    teacher.setEmail(email);
                if(mobileNumber!="")
                    teacher.setMobileNumber(mobileNumber);
                Main.logger.info("Teacher Data Updated Successfully");
                return;
            }
        }
        throw(new NotFoundException(String.format("Teacher with ID: %s not found.",id)));

    }

    //////////// Manage Students Functions ////////////

    void addStudent(Student student) throws NotFoundException {
        Main.logger.info("Adding New Student...");
        HashSet<Student> students = Singleton.getSingleton().getStudents();
        if(students.contains(student))
            throw (new NotFoundException(String.format("Student with ID: %s already exists.",student.getId())));
        Main.logger.info(String.format("Student %s added successfully",student.getName()));
        students.add(student);
    }
    void removeStudent(String id) throws NotFoundException {
        Main.logger.info("Removing student with ID: " +id);
        HashSet<Student> students = Singleton.getSingleton().getStudents();
        for (Student student : students) {
            if(student.getId().equals(id))
            {
                students.remove(student);
                Main.logger.info(String.format("Student %s added successfully",student.getName()));
                return;
            }
        }
        throw (new NotFoundException(String.format("Student with ID: %s not found",id)));

    }
    void viewAllStudents()
    {
        System.out.println("List Of Students :");

        for(Student s : Singleton.getSingleton().getStudents())
        {
            System.out.println("\t"+s);
        }
    }
    void viewStudentDetails(String id) throws NotFoundException {
        HashSet<Student> students = Singleton.getSingleton().getStudents();
        for (Student student : students) {
            if(student.getId().equals(id))
            {
                System.out.println(student);
                return;
            }
        }
        throw (new NotFoundException(String.format("Student with ID: %s not found",id)));

    }
    void updateStudentData(String id, String name, String email, String mobileNumber,String age, String address, String gender) throws NotFoundException {
        HashSet<Student> students = Singleton.getSingleton().getStudents();
        for (Student student : students) {
            if(student.getId().equals(id))
            {
                if(name!="")
                    student.setName(name);
                if(email!="")
                    student.setEmail(email);
                if(mobileNumber!="")
                    student.setMobileNumber(mobileNumber);
                if(age !="")
                    student.setAge(age);
                if(address!="")
                    student.setAddress(address);
                if(gender!="")
                    student.setGender(gender);
                Main.logger.info(("Student Data Updated"));
                return;
            }
        }
        throw (new NotFoundException(String.format("Student with ID: %s not found",id)));
    }
}
