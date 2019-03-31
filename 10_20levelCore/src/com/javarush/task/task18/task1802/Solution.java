package com.javarush.task.task18.task1802;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
        public static void main(String[] args) throws Exception {
            ArrayList<Integer> bytes = new ArrayList<>();
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
                System.out.println(Collections.min(bytes));


            }
            catch (IOException e){
                e.printStackTrace();

            }
            finally {
                in.close();
            }

        }
    }


