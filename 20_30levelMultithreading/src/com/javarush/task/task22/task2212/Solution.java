package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) {
            return false;
        } else if (telNumber.startsWith("+") && telNumber.matches("\\+[0-9]{12}")) {
            return true;

        } else if (telNumber.matches("\\+\\d{2}\\([0-9]{3}\\)[0-9]{7}")) {
            return true;
        } else if (telNumber.matches("\\+?\\d{2}\\(?[0-9]{3}\\)?[0-9]{3}\\-?[0-9]{2}\\-?[0-9]{2}")) {
            return true;
        } else if (telNumber.matches("[0-9]{6}\\-?[0-9]{2}\\-?[0-9]{2}")) {
            return true;
        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380502087569"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
//        System.out.println( checkTelNumber("+38)050(1234567"));
//        System.out.println( checkTelNumber("050ххх4567"));
//        System.out.println( checkTelNumber("050123456"));
//        System.out.println( checkTelNumber("(0)501234567"));
    }
}
