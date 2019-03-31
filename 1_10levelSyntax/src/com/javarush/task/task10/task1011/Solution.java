package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s="Я не хочу изучать Java, я хочу большую зарплату";

        int count=0;
        while (count < 40)
            for (int i=0; i < 40; i++) {

                System.out.println(s);
                s = s.substring(1);
                count++;
            }
    }

}

