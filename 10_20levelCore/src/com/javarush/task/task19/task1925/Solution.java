package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]))){
            String s  ="";
            StringBuilder stringBuilder = new StringBuilder();
            while ((s=bufferedReader.readLine())!=null ){
                String[] splitWorld =  s.split("\\s");
                for (String s1:splitWorld
                ) {
                    if (s1.length()>6 ){
                        stringBuilder.append(s1).append (",");
                    }

                }
            }
             bufferedWriter.write(stringBuilder.toString().substring(0, stringBuilder.length()-1));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
