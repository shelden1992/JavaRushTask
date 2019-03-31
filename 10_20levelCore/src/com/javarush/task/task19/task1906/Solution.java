package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        String str2 = bufferedReader.readLine();

        bufferedReader.close();
        FileReader fileReader=null;
        FileWriter fileWriter=null;
        try {

            fileReader= new FileReader(str );
            fileWriter=new FileWriter(str2);
            String s;
            byte[] c=new byte[256];
            int count = -1;



            while (fileReader.ready()){//ready?
                int data = fileReader.read();

                if(count % 2 == 0||count==0){
                    fileWriter.write(data);

                }
                count++;
            }





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fileReader.close();
            fileWriter.close();
        }

    }
}
