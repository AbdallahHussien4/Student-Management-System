package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private static String id;
    private static String name;
    private static String email;
    private static String mobileNumber;
    protected static final Logger logger =  LogManager.getLogger(Main.class);
    public static void print(String words )
    {
        System.out.println(words);
    }

    public static void welcomeGeneral()
    {
        print("////////////// Welcome /////////////");
        print("Please Enter Your Role Number:");
        print("\t 1: Admin");
        print("\t 2: Teacher");
        print("\t 3: Student");
        print("\t 0: Exit");
    }

    public static void main(String[] args)  {
        // Seed DB with dummy objects.
        Seeds.seed();
        // Read user info from properties file.
        try (InputStream input = new FileInputStream("src/main/resources/info.properties")) {

            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            id = prop.getProperty("id");
            name = prop.getProperty("name");
            email = prop.getProperty("email");
            mobileNumber = prop.getProperty("mobileNumber");

        } catch ( IOException ex) {
            logger.error("Can't open properties file");
        }
        boolean exit = false;
        while(true && !exit)
        {

            welcomeGeneral();
            Scanner scanner = new Scanner(System.in);
            String role = scanner.nextLine();
            if (role.equals("0"))
            {
                exit = true;
                break;
            }
            UtilFactory utilFactory = new UtilFactory();
            UserUtilInterface userUtilInterface = utilFactory.getUtil(role);
            UserFactory userFactory = new UserFactory();
            User user = userFactory.getUser(role,id,name,email,mobileNumber);
            boolean exitUser = false;
            while(true && !exitUser)
            {
                userUtilInterface.welcome();
                String function = scanner.nextLine();
                exitUser = userUtilInterface.handleLogic(user,function);
            }
        }
    }
}