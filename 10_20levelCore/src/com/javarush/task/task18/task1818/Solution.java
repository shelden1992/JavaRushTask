package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner =new Scanner(System.in);
        String writeFileofReadFileAndLast=scanner.nextLine();
        String readFile2=scanner.nextLine();
        String readLstFileAndWriteToFirst=scanner.nextLine();




        OutputStream f1out=null;
        InputStream f2in=null;
        InputStream f3in=null;



            f1out=new FileOutputStream( writeFileofReadFileAndLast);
            f2in=new FileInputStream(new File(readFile2));
            f3in=new FileInputStream(new File(readLstFileAndWriteToFirst));

            while (f2in.available() > 0) {
                byte[] buffer=new byte[f2in.available()];
                int a=f2in.read(buffer);
                f1out.write(buffer, 0, a);
            }
        while (f3in.available()>0){
            byte[] buffer=new byte[f3in.available()];
            int a = f3in.read(buffer);
            f1out.write(buffer, 0,a);
        }


        scanner.close();

        f2in.close();
        f1out.close();
        f3in.close();
        }

    }
//Users/macuser/Desktop/Directory/Text2.txt