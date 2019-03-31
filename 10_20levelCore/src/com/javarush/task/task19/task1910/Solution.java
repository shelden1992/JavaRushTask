package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in))) {
            String readFile=bufferedReader.readLine();
            String writeFile=bufferedReader.readLine();
            try (BufferedReader reader=new BufferedReader(new FileReader(readFile));
                 BufferedWriter writer=new BufferedWriter(new FileWriter(writeFile))) {
                StringBuilder stringBuilder=new StringBuilder();
                while (reader.ready()) {
                    String s;
                    stringBuilder.append(s=reader.readLine().replaceAll("[\\p{P}\\n]", ""));
                }
//                System.out.println(Arrays.asList(stringBuilder));
                writer.append(stringBuilder);
            }

        }

    }
}
