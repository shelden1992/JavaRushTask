package com.javarush.task.task18.task1801;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList <Integer> bytes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
String nameFile = scanner.nextLine();
        scanner.close();

        int date2 = 0;
        File file = null ;
        FileInputStream in = null;
        try {
            file   = new File( nameFile);
            in = new FileInputStream(file);

            while (in.available()>0){
                int date = in.read();
                bytes.add(date);

        }
            System.out.println(Collections.max(bytes));


        }
        catch (IOException e){
            e.printStackTrace();

        }
        finally {
            in.close();
        }

    }
}
