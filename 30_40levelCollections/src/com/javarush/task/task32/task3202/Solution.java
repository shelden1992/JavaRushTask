package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer=getAllDataFromInputStream(new FileInputStream("testFile.log"));
//        StringWriter writer=getAllDataFromInputStream(new FileInputStream("/Users/macuser/Desktop/мама/allFilesContent.txt"));
        assert writer != null;
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter stringWriter=new StringWriter();
        if (is != null)
            try (BufferedReader stringReader=new BufferedReader(new InputStreamReader(( is )))) {

                String str;
                while (( str=stringReader.readLine() ) != null) {

                    stringWriter.write(str);

                }
            } finally {
                stringWriter.close();

            }

        return stringWriter;
    }
}