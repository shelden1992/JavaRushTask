package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String[]> list=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        String file1=scanner.nextLine();
        String file2=scanner.nextLine();
        scanner.close();

        float toFloat=0;
        String s;
        BufferedReader bufferedReader=null;
        PrintWriter printWriter=null;
        String[] words=null;
        try {
            bufferedReader=new BufferedReader(new FileReader(file1));
            printWriter=new PrintWriter(new FileWriter(file2));
            while (( s=bufferedReader.readLine() ) != null) {
                words=s.split("\\s");
                list.add(words);

            }
            for (String[] lists : list) {
                for (String str : lists
                        ) {
                    toFloat=Float.parseFloat(str);
                    printWriter.print(Math.round(toFloat));
                    printWriter.print(" ");

                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
            printWriter.close();
        }
    }
}
