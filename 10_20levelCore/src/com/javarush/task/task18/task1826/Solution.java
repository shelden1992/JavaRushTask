package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader("/Users/macuser/Desktop/Directory/Text.txt"));
            String lineInFile;
            while ((lineInFile= bufferedReader.readLine() ) != null) {

//                lineInFile.matches("^e");
// Pattern pattern=Pattern.compile("(^e)"
//                Matcher matcher=pattern.matcher(lineInFile);

                System.out.println(  lineInFile.matches("^-e"));

            }


        } catch (IllegalStateException e) {
            System.out.println("End with code: " +1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
