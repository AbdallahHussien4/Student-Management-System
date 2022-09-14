package org.example;

public interface UserUtilInterface {
    public static void print(String words )
    {
        System.out.println(words);
    }
    public void welcome();
    public boolean  handleLogic(User user,String function);
}
