package org.example;

import java.util.ArrayList;
import java.util.HashSet;

public class Admin extends User{


    public Admin(String id, String name, String email, String mobileNumber) {
        super(id,name,email,mobileNumber);
    }

    //////////// Manage Teachers Functions ////////////
    void addTeacher(String id, String name, String email, String number)
    {
        //TODO : UUID Class Numeric ID.
        Teacher teacher = new Teacher(id,name,email,number);
        System.out.println("Added teacher : " +name);
        HashSet<Teacher> teachers = Singleton.getSingleton().getTeachers();
        if(teachers.contains(teacher))  // TODO : Use Exceptions
            System.out.println("Teacher with ID: "+ id +" already exists."); // TODO : (Log For J V2).
        teachers.add(teacher);
    }
    void removeTeacher(String id)
    {
        System.out.println("Remove teacher with ID: " +id);
        HashSet<Teacher> teachers = Singleton.getSingleton().getTeachers();
        boolean found = false;
        for (Teacher teacher : teachers) {
            if(teacher.getId().equals(id))
            {

                teachers.remove(teacher);
                found = true;
                System.out.println("Teacher Removed");
            }
        }
        if(!found)
            System.out.println("Teacher not found");

    }
    void viewAllTeachers()
    {
        // TODO : View ALL Data (String.Format)
        System.out.println("List Of Teachers :");

        for(Teacher t : Singleton.getSingleton().getTeachers())
        {
            System.out.println(t.getName());
        }
    }
    void viewTeacherDetails(String id)
    {
        HashSet<Teacher> teachers = Singleton.getSingleton().getTeachers();
        boolean found = false;
        for (Teacher teacher : teachers) {
            if(teacher.getId().equals(id))
            {
                System.out.println(teacher);
                found = true;
            }
        }
        if(!found)
            System.out.println("Teacher not found");

    }
    void updateTeacherData(String id, String name, String email, String mobileNumber)
    {
        HashSet<Teacher> teachers = Singleton.getSingleton().getTeachers();
        boolean found = false;
        for (Teacher teacher : teachers) {
            if(teacher.getId().equals(id))
            {
                if(name!="")
                    teacher.setName(name);
                if(email!="")
                    teacher.setEmail(email);
                if(mobileNumber!="")
                    teacher.setMobileNumber(mobileNumber);
                found = true;
                System.out.println("Teacher Data Updated");

            }
        }
        if(!found)
            System.out.println("Teacher not found");
    }

    //////////// Manage Students Functions ////////////

    void addStudent(Student student)
    {
        System.out.println("Added student : " +student.getName());
        HashSet<Student> students = Singleton.getSingleton().getStudents();
        if(students.contains(student))
            System.out.println("Student with ID: "+ student.getId() +" already exists.");
        students.add(student);
    }
    void removeStudent(String id)
    {
        System.out.println("Remove student with ID: " +id);
        HashSet<Student> students = Singleton.getSingleton().getStudents();
        boolean found = false;
        for (Student student : students) {
            if(student.getId().equals(id))
            {
                students.remove(student);
                found = true;
                System.out.println("Student Removed");
            }
        }
        if(!found)
            System.out.println("Student not found");

    }
    void viewAllStudents()
    {
        System.out.println("List Of Students :");

        for(Student s : Singleton.getSingleton().getStudents())
        {
            System.out.println(s.getName());
        }
    }
    void viewStudentDetails(String id)
    {
        HashSet<Student> students = Singleton.getSingleton().getStudents();
        boolean found = false;
        for (Student student : students) {
            if(student.getId().equals(id))
            {
                System.out.println("Student: "+ student.getName()+ " ID: "+student.getId()+ " Email: "+ student.getEmail()+ " Phone: "+ student.getMobileNumber()+ " Age: "+ student.getAge()+ "Address: "+student.getAddress()+ "Gender: "+student.getGender());
                found = true;
            }
        }
        if(!found)
            System.out.println("Student not found");
    }
    void updateStudentData(String id, String name, String email, String mobileNumber,String age, String address, String gender)
    {
        HashSet<Student> students = Singleton.getSingleton().getStudents();
        boolean found = false;
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
                found = true;
                System.out.println("Student Data Updated");

            }
        }
        if(!found)
            System.out.println("Student not found");
    }
}
