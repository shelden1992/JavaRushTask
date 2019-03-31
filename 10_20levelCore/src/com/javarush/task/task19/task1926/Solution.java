package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in))) {

            String fileName=bufferedReader.readLine();

            try (BufferedReader bufReadFile=new BufferedReader(new FileReader(fileName))) {
                String readLineFromFile;
                while (( readLineFromFile=bufReadFile.readLine() ) != null) {
                    System.out.println(new StringBuilder(readLineFromFile).reverse());

                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


