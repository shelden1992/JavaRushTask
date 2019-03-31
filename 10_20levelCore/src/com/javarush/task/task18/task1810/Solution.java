package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream in = null;
//
       while (true) {
           String nameFile=scanner.nextLine();
           File file = new File(nameFile);
           try {
               in =new FileInputStream(file);
               long len = file.length();
               if (len<1000){
                   throw  new DownloadException();

               }

           } catch (FileNotFoundException e) {
               e.printStackTrace();
           }
           finally {
               in.close();
           }

           }


    }


    public static class DownloadException extends Exception {


    }
}
