package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        double count1=0;
        double count2=0;
        ArrayList<String> list=new ArrayList();
        FileInputStream fileInputStream=new FileInputStream(args[0]);

        while (fileInputStream.available() > 0) {
            int a=fileInputStream.read();
            list.add(String.valueOf((char) a));

        }
        fileInputStream.close();

        for (String s : list) {
            if (s.equals(" ")) {
                count1++;
            } else count2++;

        }

        System.out.printf("%.2f",  (count1 / (count2+count1) * 100));
    }

    }

