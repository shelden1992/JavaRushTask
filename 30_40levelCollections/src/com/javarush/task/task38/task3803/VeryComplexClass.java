package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    String s="";
    static Object o=new Object();

    public void methodThrowsClassCastException() {
        String s=(String) o;
        System.out.println(s);

    }

    public void methodThrowsNullPointerException() {
        Object o=null;
        System.out.println(o.equals(""));
    }

    public static void main(String[] args) {
    }
}
