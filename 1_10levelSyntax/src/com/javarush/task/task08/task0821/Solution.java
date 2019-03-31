package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map <String, String> map = new HashMap<>();
        map.put("1","Вася");
        map.put("1","Вася");
        map.put("3","Вася");
        map.put("4","Вася");
        map.put("5","Вася");
        map.put("6","Вася");
        map.put("7","Вася");
        map.put("8","Вася");
        map.put("9","Вася");
        map.put("10","Вася");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
