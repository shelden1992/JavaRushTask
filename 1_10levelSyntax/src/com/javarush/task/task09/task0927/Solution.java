package com.javarush.task.task09.task0927;

import java.util.*;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String,Cat>map = new HashMap<>();
        map.put("Вася1", new Cat("Вася1"));
        map.put("Вася2", new Cat("Вася2"));
        map.put("Вася3", new Cat("Вася3"));
        map.put("Вася4", new Cat("Вася4"));
        map.put("Вася5", new Cat("Вася5"));
        map.put("Вася6", new Cat("Вася6"));
        map.put("Вася7", new Cat("Вася7"));
        map.put("Вася8", new Cat("Вася8"));
        map.put("Вася9", new Cat("Вася9"));
        map.put("Вася10", new Cat("Вася10"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat>set = new HashSet<> (map.values());
//         Map.Entry<String, Cat> map = map.entrySet();
    return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
