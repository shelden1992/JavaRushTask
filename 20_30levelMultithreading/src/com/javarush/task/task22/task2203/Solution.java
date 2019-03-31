package com.javarush.task.task22.task2203;

import java.util.Arrays;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String newString = "";
        if (string == null){
            throw  new TooShortStringException();
        }
        try {
            String[]array = string.split("\t");
            if (array.length<3){
                throw new TooShortStringException();
            }
            else {
                newString = array[1] ;

                return newString;}



        }
        catch (RuntimeException e){
            new TooShortStringException();

        }
        return newString;

    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
