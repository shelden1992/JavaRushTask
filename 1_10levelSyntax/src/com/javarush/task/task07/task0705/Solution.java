package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {


    public static void main(String[] args) throws Exception {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        int d = Integer.parseInt(bufferedReader.readLine());

        int i = 1;

        ArrayList <Integer>fibon1 = new ArrayList<>();
        for (int a = 0; a < 1_000_000; i = i + a) {
            a = i + a;

            fibon1.add(a,i);
//            fibon1.get(d)
            System.out.println(fibon1.add(1));}
    }
}



// System.out.println(());

//            int[]mass = new int [20000];
//            for (int c = 0; c<mass.length; c++)
//                mass[c] = a;
//
//            int[]mass2 = new int [20000];
//            for (int e = 0; e<mass.length; e++)
//                mass[e] = i;
//
//              System.out.print(i+" ");
//            System.out.print(a+" ");}
//            System.out.println(mass[d]);
//           System.out.println(mass2[d]);





