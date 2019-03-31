package com.javarush.task.task10.task1004;

/* 
Задача №4 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        short number=9;
        char zero=  '0';
        int nine=( zero +  number );
        System.out.println((char)nine);//должно быть 9! - вы ходит 57 - в двоичной системе это и есть 9!!!!

        //System.out.println(char(nine))


        //short number = 9; -- число равно 9
        //char zero = '0';  --  как символ - 0, а как число - код нуля, то есть 48
        //int nine = (char)(zero + number); 48 + 9 = 57 - число 57 (пишите в int).
        // Хотите получить символ по коду 57 - найн должен быть типа char а не int
    }
}
