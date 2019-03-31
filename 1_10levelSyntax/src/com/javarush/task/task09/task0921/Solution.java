package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();//ты задал вопрос как ввывести все введеные значение
        // ответ динамический массив!!! просто помести все введенные значение, а потом вызови!!!
        while (true) {

            try {//очень хороший способ без if и т.д просто пишешь ошибку и перехватываешь


                int x = Integer.parseInt(scanner.nextLine());
                array.add(x);
//                String s = scanner.nextLine();

            } catch (NumberFormatException e) {
                break;

            }
        }
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }

    }
}
