package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> array=new ArrayList<>();


        Scanner scanner=new Scanner(System.in);
        String nameFile=scanner.nextLine();
        scanner.close();

        int count=0;
        File file=null;
        FileInputStream in=null;
        int date=0;
        try {
            file=new File(nameFile);
            in=new FileInputStream(file);

            while (in.available() > 0) {
                date=in.read();
                array.add(date);
                if (date==44){
                    count++;
                }


            }
            in.close();


            System.out.println(count);



        } catch(IOException e ){
        e.printStackTrace();}


    }
}
