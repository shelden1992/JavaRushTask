package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
        public static void main(String[] args) throws IOException
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//создали буффер
            String fileName = reader.readLine(); //путь к файлу

            reader.close();//закрыли буфер
            InputStream inStream = new FileInputStream(fileName);//создать новый файл и поместили в новый файл наш путь
            while ( inStream.available() > 0) {   //немного магии
                System.out.print((char)inStream.read());
            }
            System.out.println();
            inStream.close();//закрыли поток помещения

        }
    }
