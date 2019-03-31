package com.javarush.task.task18.task1805;


import java.io.FileInputStream;

/*
Самые редкие байты
*/
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Set<Integer> bytes=new TreeSet<>();


        Scanner scanner=new Scanner(System.in);
        String nameFile=scanner.nextLine();
        scanner.close();

        int date2=0;
        File file=null;
        FileInputStream in=null;
        int date=0;
        try {
            file=new File(nameFile);
            in=new FileInputStream(file);

            while (in.available() > 0) {
                date=in.read();
                bytes.add(date);

            }


            in.close();

            if (bytes.size() <= 0) {
                return;
            } else {
                for (Integer ints: bytes)
                System.out.print(ints+ " ");

                }


        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

