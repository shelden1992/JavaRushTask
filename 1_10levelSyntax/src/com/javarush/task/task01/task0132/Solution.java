package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
     int result = 0;
        char[] st = String.valueOf( number).toCharArray();
        for (Character lockChar: st
             ) {
             result+= Integer.parseInt(String.valueOf(lockChar));

        }
        return result;
    }
}