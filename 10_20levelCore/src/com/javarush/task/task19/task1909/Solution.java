package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in))) {
            String path1=bufferedReader.readLine();
            String path2=bufferedReader.readLine();

            try (BufferedReader reader=new BufferedReader(new FileReader(path1));
                 BufferedWriter writer=new BufferedWriter(new FileWriter(path2))) {

String s;
                while ((s = reader.readLine() )!= null) {

writer.write(s.replaceAll("\\.", "!"));

                        }
                    }

                }
            }

        }

