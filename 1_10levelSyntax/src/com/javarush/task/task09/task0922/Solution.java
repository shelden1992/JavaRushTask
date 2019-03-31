package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        Date date = new Date();
        System.out.println("Введите дату в формате: yyyy-MM-dd");
        String dateString = scanner.readLine();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       String str = args.length == 0 ? dateString : args[0];

        try {

            Date docDate = simpleDateFormat.parse(dateString);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
            System.out.println(simpleDateFormat2.format(docDate).toUpperCase());

        } catch (Exception e) {
            System.out.println("Не получилось" + dateString);
        }
    }
}

