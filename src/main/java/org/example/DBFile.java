package org.example;

import java.sql.*;

public class DBFile {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "1234";

        System.out.println("Loading driver...");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

    System.out.println("Connecting database...");

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM students where name =?;");
            pstmt.setString(1,"Mohammed");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                Student  st = new Student();
                st.setAge(rs.getInt(5)+"");
                st.setName(rs.getString(2));

                System.out.println(st);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
