package org.example;

public interface LamdaTest {
   String ss = ";";
    void print ();

    default String getDate(){
        print();
        return "dtat";
    }

    static void talk(){
        System.out.println("talk");
    }

    static void newTalk(){

    }

}
