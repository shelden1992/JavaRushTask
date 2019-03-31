package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String[]> list=new ArrayList<>();
        try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in))) {

            String r=bufferedReader.readLine();
            String w=bufferedReader.readLine();

            try (BufferedReader bufRead=new BufferedReader(new FileReader(r));
                 BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(w))) {
                String[] ss;

                while (bufRead.ready()) {
                    ss=bufRead.readLine().split("\\s");//
                    System.out.println(Arrays.asList(ss));
                    for (String str : ss) {
                        if (str.matches("\\d+")) {
                            bufferedWriter.write(str + " ");
                        }


                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
