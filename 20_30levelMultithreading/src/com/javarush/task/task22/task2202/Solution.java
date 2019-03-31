package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        String newString;
        if (string == null) {//проверяем на null
            throw new TooShortStringException(); //если  да - кидаем исключение
        }


        try {
                String[] array = string.split(" ");  //
                if (array.length<5)
                    throw new TooShortStringException();
                else {
                    newString = array[1] + " " + array[2] + " " + array[3] + " " + array[4];
                }




            return newString ;

        } catch (RuntimeException e) {
            throw new TooShortStringException();

        }

    }

    public static class TooShortStringException extends RuntimeException {
    }
}
