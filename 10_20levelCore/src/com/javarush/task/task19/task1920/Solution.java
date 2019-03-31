package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader=new BufferedReader(new FileReader( args[0]));
        String s="";
        Map<String, Double> map=new HashMap<>();
        while (( s=bufferedReader.readLine() ) != null) {

            String[] array=s.split("\\s");

            if (map.containsKey(array[0])) {
                map.put(array[0], map.get(array[0]) + Double.parseDouble(array[1]));
            } else
                map.put(array[0], Double.parseDouble(array[1]));


        }
        double max=Collections.max(map.values());

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue().equals(max)) {
                System.out.println(entry.getKey());
            }
        }
        bufferedReader.close();


    }


}
