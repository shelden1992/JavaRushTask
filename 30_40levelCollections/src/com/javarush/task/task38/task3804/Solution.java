package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return FactoryExeption.class;
    }

    public static void main(String[] args) {
//        try {
//            System.out.println( new FactoryExeption().getExeption(ApplicationExceptionMessage.UNHANDLED_EXCEPTION));
//            System.out.println(new FactoryExeption().getExeption(UserExceptionMessage.USER_DOES_NOT_EXIST));
//            System.out.println(new FactoryExeption().getExeption(DatabaseExceptionMessage.NOT_ENOUGH_CONNECTIONS));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}