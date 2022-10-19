package org.example;

public class LamdaTestImpl implements  LamdaTest{
    @Override
    public void print() {

    }

    @Override
    public String getDate() {
        return LamdaTest.super.getDate();
    }
}
