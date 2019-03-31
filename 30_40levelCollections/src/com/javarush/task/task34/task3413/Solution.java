package com.javarush.task.task34.task3413;

/* 
Кеш на основании SoftReference
*/

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();

        for (long i = 0; i < 2_500_000; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }
//        HashMap<Integer, String > map =  new HashMap<>();
//        map.put(1, "1");
//        map.remove(1);
    }
}