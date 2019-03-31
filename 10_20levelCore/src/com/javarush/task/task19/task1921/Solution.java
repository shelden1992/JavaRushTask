package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {

//    Иванов Иван Иванович 31 12 1987
//    Вася 15 5 2013
//    /Users/macuser/Desktop/мама/allFilesContent.txt

    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try (BufferedReader bufferedReader =new BufferedReader(new FileReader(args[0]))){
            String s = "";
            while ((s = bufferedReader.readLine())!= null){
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder integerStringBuilder= new StringBuilder();

                SimpleDateFormat data = new SimpleDateFormat("dd MM yyyy");
                Date date = new Date();

                String[]sArray = s.split(" " ); /*"бла бла"*/
                for (String st: sArray) {


                    if (Character.isDigit(st.toCharArray()[0])){
                        integerStringBuilder.append(st).append(" ");

                    }
                    else {
                        stringBuilder.append(st).append(" ");

                    }
                }

                PEOPLE.add( new Person(stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1), data.parse(integerStringBuilder.toString())));
//                System.out.println(PEOPLE);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}