package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> toCharArray = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
           String s = list.get(i);
            if (s.length()%2==0){
                System.out.print(s+" ");
                System.out.print(s+" ");
                System.out.println();
            }
            else if (s.length()%2!=0){
            System.out.print(s+" ");
            System.out.print(s+" ");
            System.out.print(s+" ");
            System.out.println();}

        }

//        for (int i = 0; i < toCharArray.size(); i++) {
//            System.out.println(toCharArray.get(i));
        }
    }
//}
