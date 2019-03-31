package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list=new ArrayList<>();
        byte [] bytes=new byte[0];
        int count=0;
        String file1=buf.readLine();
        String file2=buf.readLine();
        FileInputStream inputStream=new FileInputStream( file1);//читаем из Text2-го файла

        //записываем в Text2-го файла файлт Text1
        FileInputStream inputStream2=new FileInputStream(file2);//запись  в Text1-й фйл
        while (inputStream.available() > 0) {//читаем из 2го файла, который ввели

            bytes = new byte[inputStream.available()];
              count=inputStream.read(bytes);

        }
        FileOutputStream outputStream=new FileOutputStream( file1);
        while (inputStream2.available() > 0) {
            int a=inputStream2.read();
            outputStream.write(a);

        }
        outputStream.write(bytes, 0, count);


        inputStream.close();
        inputStream2.close();
        outputStream.close();
        buf.close();


    }


}


