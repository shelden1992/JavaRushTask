package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке
*/

public class Solution {

    public static List<String> lines = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println(lines);
    }
    static {
        File file = new File(Statics.FILE_NAME);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String str = scanner.nextLine();
                lines.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }
}
