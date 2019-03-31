package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream=null;
        FileOutputStream outputStream=null;
        try {
            inputStream=new FileInputStream("/Users/macuser/Desktop/Directory/Text.txt");
            // Создаем поток-записи-байт-в-файл
            outputStream=new FileOutputStream("/Users/macuser/Desktop/Directory2/Text.txt");

            if (inputStream.available() > 0) {
                //читаем весь файл одним куском
                byte[] buffer=new byte[inputStream.available()];
                int count=inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            outputStream.close();

        }

    }
}
