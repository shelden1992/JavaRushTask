package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    private static boolean flag;


    public static void writeMessage(String message) {
        System.out.println(message);


    }


    public static String readString() {
        String s = null;


        while (true) {
            try {

                s = bufferedReader.readLine();
                break;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                readString();


            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return s;


    }

    public static int readInt() {
        int a = 0;
        while (true) {
            try {

                a = Integer.parseInt(readString());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз");
                readInt();
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return a;
    }
}
