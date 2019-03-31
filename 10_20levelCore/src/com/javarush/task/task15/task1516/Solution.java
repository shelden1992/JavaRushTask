package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {

    public int intVar;

    double doubleVar;
    Double DoubleVar;
    boolean booleanVar;
    Object ObjectVar;
    Exception ExceptionVar;
    String StringVar;


    public static void main(String[] args) {
        Solution solution= new Solution();


        System.out.println(solution.intVar + " "+ solution.doubleVar + " " + solution.DoubleVar + " " + solution.booleanVar + " " + solution.ObjectVar + " " + solution.ExceptionVar + " " + solution.StringVar);
    }
}
