package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;
import com.javarush.task.task33.task3310.tests.FunctionalTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
//    private static Shortener shortener;

    public static void main(String[] args) {

//        Shortener shortener=new Shortener(new HashMapStorageStrategy());
        testStrategy(new HashMapStorageStrategy(), 100);
//        Shortener shortener1 = new Shortener(new OurHashMapStorageStrategy());
        testStrategy(new OurHashMapStorageStrategy(), 100);
        testStrategy(new FileStorageStrategy(), 100);
        testStrategy(new OurHashBiMapStorageStrategy(), 100);
        testStrategy(new HashBiMapStorageStrategy(), 100);
        testStrategy(new DualHashBidiMapStorageStrategy(), 100);
        FunctionalTest functionalTest = new FunctionalTest();
//        functionalTest.testStorage();
    }


    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
//        строк возвращать множество идентификаторов. Идентификатор для каждой отдельной строки нужно получить, используя shortener.
        Set<Long> id=new HashSet<>();
        for (String st : strings
        ) {
            id.add(shortener.getId(st));
        }

        return id;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {  //это нужно исключительно для тестирование
        Set<String> str=new HashSet<>();
        for (Long lon : keys
        ) {
            str.add(shortener.getString(lon));


        }
        return str;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Set<String> setRandomString=new HashSet<>();
        Set<Long> key=new HashSet<>();
        Set<String> strShorter=new HashSet<>();

        Helper.printMessage(strategy.getClass().getSimpleName());
        for (int i=0; i < elementsNumber; i++) {  //Генерировать тестовое множество строк, используя Helper и заданное количество элементов elementsNumber.

            String s=Helper.generateRandomString();
            setRandomString.add(s);
//            Helper.printMessage(s);
        }
        Shortener shortener=new Shortener(strategy);
        Date d1=new Date();

        for (String st : setRandomString
        ) {
            long l=shortener.getId(st);
            key.add(l);
//            Helper.printMessage(String.valueOf(l));
        }
        Date d2=new Date();

//        Helper.printMessage(String.valueOf(set.size()));
        Helper.printMessage(String.valueOf(d2.getTime() * 1000 - d1.getTime() * 1000)); //"time of work method shortener.getId "

        Date d3=new Date();
        for (Long k : key
        ) {
            String s=shortener.getString(k);
            strShorter.add(s);
//            Helper.printMessage(s);

        }
        Date d4=new Date();
        Helper.printMessage(String.valueOf(d4.getTime() * 1000 - d3.getTime() * 1000)); //"time of work method shortener.getString "

        if (setRandomString.size() == strShorter.size()) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }

    }
}
