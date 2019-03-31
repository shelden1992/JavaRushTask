package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Byte> bufferList=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        String nameFile1=scanner.nextLine();
        String nameFile2=scanner.nextLine();
        scanner.close();
        scanner.close();
        File fileRead=new File(nameFile1);
        File fileWrite=new File(nameFile2);
        FileInputStream in1=null;
        FileOutputStream out2=null;
        try {
            in1=new FileInputStream(fileRead);
            out2=new FileOutputStream(fileWrite);
            if (in1.available() > 0) {

                byte[] buffer=new byte[in1.available()];
                byte temp;
                int count=in1.read(buffer);

                for (int i=0; i < count / 2; i++) {
                    temp=buffer[count - i - 1];
                    buffer[count - i - 1]=buffer[i];
                    buffer[i]=temp;
                }


                out2.write(buffer, 0, count);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in1.close();
            out2.close();
        }


    }
}
