package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader=new BufferedReader(new FileReader(args[0]));
        String s="";
            Map<String, Double> map=new TreeMap<>();
            while (( s=bufferedReader.readLine() ) != null) {

                String[] array=s.split("\\s");

                if (map.containsKey(array[0])) {
                    map.put(array[0], map.get(array[0]) + Double.parseDouble(array[1]));
                } else
                    map.put(array[0], Double.parseDouble(array[1]));


            }
//                Иванов 1.35
//                Петров 5.1
            for (Map.Entry<String, Double> entry: map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            bufferedReader.close();


    }



}
