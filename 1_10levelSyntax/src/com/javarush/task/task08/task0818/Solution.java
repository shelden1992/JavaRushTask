package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map=new HashMap<>();
        map.put("Васькин1", 500);
        map.put("Васькин2", 600);
        map.put("Васькин3", 200);
        map.put("Васькин4", 5040);
        map.put("Васькин5", 50110);
        map.put("Васькин6", 100);
        map.put("Васькин7", 2);
        map.put("Васькин8", 10000);
        map.put("Васькин9", 1);
        map.put("Васькин10", 500);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator iteratorMap=map.entrySet().iterator();

        while (iteratorMap.hasNext()) {
            Map.Entry<String,Integer>entry =(Map.Entry<String, Integer>) iteratorMap.next();

//            Map.Entry entry=(Map.Entry) iteratorMap.next();
            if ((int) entry.getValue() < 500) {
                iteratorMap.remove(); //не принимает на вход элементов!!!! можем удалить только текущий элемент!!!!

            }
        }

    }

    public static void main(String[] args) {


    }
}