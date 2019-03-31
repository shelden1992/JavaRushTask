package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        ArrayList<String[]> str=new ArrayList<>();
        try (BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))) {
            fileName=reader.readLine();
        }

        try (BufferedReader reader=new BufferedReader(new FileReader(fileName))) {
            String s;
            while (( s=reader.readLine() ) != null) {
                str.add(( s.split("[.,?!:; ]+") ));
            }
        }


        int count=0;
        for (String[] word : str) {
            for (String strin : word) {
                if (strin.equals("world"))
                    count++;

            }
        }
        System.out.println(count);

    }
}