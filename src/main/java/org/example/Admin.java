package org.example;

import java.util.ArrayList;

public class Admin {
    private String id;
    private String name;
    private String email;
    private String mobileNumber;

    public Admin(String id, String name, String email, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    void addTeacher(Teacher teacher)    //Take Object or use setters ?
    {
        System.out.println("Add teacher : " +teacher.getName());
        ArrayList<Teacher> teachers = TeachersStudentsSingleton.getTeachers();
        teachers.add(teacher);
    }
    void removeTeacher(Teacher teacher)     // Object Or ID ?
    {
        System.out.println("Remove teacher : " +teacher.getName());

        ArrayList<Teacher> teachers = TeachersStudentsSingleton.getTeachers();
        teachers.remove(teacher);
    }
    void viewAllTeachers()
    {
        System.out.println("List Of Teachers :");

        for(Teacher t : TeachersStudentsSingleton.getTeachers())
        {
            System.out.println(t.getName());
        }
    }
    void viewTeacherDetails(Teacher teacher)
    {
        System.out.println("Teacher: "+ teacher.getName()+ " ID: "+teacher.getId()+ " Email: "+ teacher.getEmail()+ " Phone: "+ teacher.getMobileNumber());
    }
    void updateTeacherData()
    {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
