package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();//создали строку
        for (int i = 0; i < 20; i++) { //добавили слова
            words.add(reader.readLine());//через консоль
        }

        Map<String, Integer> map = countWords(words); //(присволии маp тот маp, который у нас есть)

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for (String string : list) {
            // если уже есть ключ, то прибавляем единицу
            if(result.keySet().contains(string)) {
                result.put(string, result.get(string) + 1);
                // Если нет, то кладем ключ и присваиваем значение 1
            } else {
                result.put(string, 1);
            }
        }



        return result;
    }

}

