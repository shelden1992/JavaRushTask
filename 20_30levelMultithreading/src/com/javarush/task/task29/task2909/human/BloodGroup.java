package com.javarush.task.task29.task2909.human;

public class BloodGroup {

   private final int code;

    public int getCode() {
        return code;
    }

    private BloodGroup(int code) {

        this.code = code;
    }

    static public BloodGroup first() {
        BloodGroup bloodGroup = new BloodGroup(1);

        return bloodGroup;


    }

    static public BloodGroup second() {
        BloodGroup bloodGroup = new BloodGroup(2);

        return bloodGroup;
    }

    static public BloodGroup third() {
        BloodGroup bloodGroup = new BloodGroup(3);

        return bloodGroup;


    }

    static public BloodGroup fourth() {
        BloodGroup bloodGroup = new BloodGroup(4);

        return bloodGroup;


    }

}
