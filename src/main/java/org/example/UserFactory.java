package org.example;

public class UserFactory {
    public User getUser(String role,String id, String name, String email, String mobileNumber)
    {
        if(role == null){
            return null;
        }
        if(role.equals("1")){
            return new Admin(id,name,email,mobileNumber);

        } else if(role.equals("2")){
            return new Teacher(id,name,email,mobileNumber);

        } else if(role.equals("3")){
            Student.StudentBuilder builder = new Student.StudentBuilder();
            builder.id(id).name(name).email(email).mobileNumber(mobileNumber);
            builder.build();
            return new Student(builder);
        }
        return null;
    }
}
