package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileReader=new FileInputStream(args[0]);
        ArrayList<String> list= new ArrayList<>();

        int count=0;
        while ( fileReader.available()>0) { //опять же считываем по байтово!
            int f=fileReader.read();
            list.add(String.valueOf((char) f));
        }
        fileReader.close();
        for (String ch:list) {
            if (ch.matches ("[a-z]") || ch.matches ("[A-Z]")){
                count++;}

        }
        System.out.println(count);






    }

}
