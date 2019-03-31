package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        String filename;


        byte[] b;
        TreeSet<String> namesList=new TreeSet<>();
        while (!( filename=scanner.nextLine() ).equals("end")) {

            namesList.add(filename);
        }

        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try {

            bufferedOutputStream=new BufferedOutputStream(new FileOutputStream("/Users/macuser/Desktop/Directory/1.mp4"));
            for (String s : namesList
                    ) {
                bufferedInputStream=new BufferedInputStream(new FileInputStream(s));
                while (bufferedInputStream.available() > 0) {
                    b=new byte[bufferedInputStream.available()];
                    int count=bufferedInputStream.read(b);
                    bufferedOutputStream.write(b, 0, count);
                }
                bufferedInputStream.close();
            }
            bufferedOutputStream.close();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            scanner.close();

        }


    }
}
///Users/macuser/Desktop/Directory/Text.txt