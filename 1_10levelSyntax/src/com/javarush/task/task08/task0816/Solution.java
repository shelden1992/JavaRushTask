package com.javarush.task.task08.task0816;

import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Stall", df.parse("JULY 1 1980"));
        map.put("Stal", df.parse("SEPTEMBER 1 1980"));
        map.put("Stallo", df.parse("OCTOBER 1 1980"));
        map.put("Sta", df.parse("NOVEMBER 1 1980"));
        map.put("St", df.parse("DECEMBER 1 1980"));
        map.put("Stallon", df.parse("JANUARY 1 1980"));
        map.put("S", df.parse("JUNE 1 1980"));
        map.put("Stallons", df.parse("JUNE 1 1980"));
        map.put("Stalslone", df.parse("JUNE 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {

        Iterator <Map.Entry <String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
//            if ()){
                iterator.remove();}


//        }


    public static void main(String[] args) {

    }
}
