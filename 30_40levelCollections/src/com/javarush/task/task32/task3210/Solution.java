package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {

        String fileName=args[0];
//        String fileName="/Users/macuser/Desktop/мама/allFilesContent.txt";
        int number=Integer.parseInt(args[1]);
//        int number=5;
        String text=args[2];
//        String text="system";
        String stringRead=null;


        try (RandomAccessFile randomAccessFile=new RandomAccessFile(fileName, "rw")) {

            randomAccessFile.seek(number); // передвинули до нумера
            byte[] buffer =new byte[text.length()];  //  создали массив байтов
            randomAccessFile.read(buffer, 0, buffer.length);

            stringRead=new String(buffer);

            randomAccessFile.seek(randomAccessFile.length());
            if (stringRead.equals(text)) {

                randomAccessFile.write("true".getBytes());
            } else randomAccessFile.write("false".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
