package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        String path=scanner.nextLine();
        BufferedReader in=null;
        scanner.close();
        char c;
        String[] word=new String[5];
        try {
            in=new BufferedReader(new FileReader(path));
            String line;

            ArrayList<String> list=new ArrayList<>();
            while (( line=in.readLine() ) != null) {
                list.add(line);
            }
            for (String x : list) {
                if (x.matches("\\s")){}
                    System.out.printf(x);
                }




///Users/macuser/Desktop/Directory/Text3.txt

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}
