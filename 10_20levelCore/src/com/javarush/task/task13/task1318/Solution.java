package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;

/* 
Чтение файла
*/

public class Solution {
        public static void main(String[] args) throws IOException
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Введите название файла");
            String s =bufferedReader.readLine();
            File file = new File(s);

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
 scanner.close();
        }
    }
