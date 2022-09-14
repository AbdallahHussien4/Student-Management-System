package org.example;

public class UtilFactory {
    public UserUtilInterface getUtil(String role)
    {
        if(role == null){
            return null;
        }
        if(role.equals("1")){
            return new AdminUtil();

        } else if(role.equals("2")){
            return new TeacherUtil();

        } else if(role.equals("3")){
            return new StudentUtil();
        }

        return null;
    }
}
