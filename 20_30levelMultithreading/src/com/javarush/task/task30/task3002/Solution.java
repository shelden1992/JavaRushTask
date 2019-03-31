package com.javarush.task.task30.task3002;

/*
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        Integer i=null;
        int radix=0;
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(s);
        String sos=null;

        if (s.startsWith("0")) {


            if (s.substring(1, 2).equals("x")) {
                sos=s.substring(2);
                radix=16;


            } else if (s.substring(1, 2).equals("b")) {
                sos=s.substring(2);
                radix=2;
            } else {
                sos=s;
                radix=8;
            }

        } else {
            sos=s;
            radix=10;
        }


        return String.valueOf(Integer.parseInt(sos, radix));
    }
}
