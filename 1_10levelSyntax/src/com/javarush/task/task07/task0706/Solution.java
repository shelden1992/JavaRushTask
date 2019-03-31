package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int sumNoEven = 0;
        int [] fifteen = new int [15];

    for (int i = 0; i<fifteen.length; i++) {
        String s = reader.readLine();
        fifteen[i] = Integer.parseInt(s);

        if (i % 2 == 0||i==0){
            for (int a = 0; a < fifteen.length; a++)
                sum += fifteen[i];}

              else if (i % 2 != 0) {
            for (int a = 0; a < fifteen.length; a++)
                sumNoEven += fifteen[i];
            }
    }

     if (sumNoEven>sum)
      System.out.println("В домах с нечетными номерами проживает больше жителей.");
       else
           System.out.println("В домах с четными номерами проживает больше жителей.");

    }
    }


