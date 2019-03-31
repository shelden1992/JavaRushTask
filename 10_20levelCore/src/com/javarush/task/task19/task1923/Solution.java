package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader  = new BufferedReader(new FileReader(args[0]));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]))){
            String s= "";
            StringBuilder stringBuilder = new StringBuilder();
            while ((s= bufferedReader.readLine())!=null){
                String[] splitWord =  (s.split("\\s"));
                for (String st: splitWord
                ) {
                    if (st.matches("\\b[\\S]*[\\d]+[\\S]*\\b")){  //if match digital+word
                        stringBuilder.append(st).append(" ");
                    }

                }




            }
            bufferedWriter.write(stringBuilder.toString());
            System.out.println(stringBuilder);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



