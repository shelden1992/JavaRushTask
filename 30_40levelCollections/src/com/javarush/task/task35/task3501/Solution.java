package com.javarush.task.task35.task3501;
/* 
Вызов статического метода
*/
public class Solution {
    public static void main(String[] args) {
        GenericStatic genericStatic = new GenericStatic();
        genericStatic.<Number> someStaticMethod(new Integer(3));
NewClass newClass =new NewClass();
//newClass.<Number> someStaticMethod(new Integer(3));

//        Number number =  GenericStatic.<Number> someStaticMethod(new Integer(3));

    }
}
