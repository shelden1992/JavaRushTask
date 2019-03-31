package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap <String, String> map = new HashMap <>();
        map.put("1", "Name");
        map.put("2", "Name");
        map.put("3", "Name");
        map.put("4", "Name");
        map.put("5", "Name");
        map.put("6", "Name");
        map.put("7", "Name");
        map.put("8", "Name");
        map.put("9", "Name");
        map.put("10", "Name");
        return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Iterator <Map.Entry <String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
            if (iterator.equals(iterator.next())){
        iterator.remove();}


    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
