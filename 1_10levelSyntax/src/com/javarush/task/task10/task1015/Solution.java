package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.List;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList <String>[] lists =new ArrayList[3];

       ArrayList  <String> list1 = new ArrayList<>();//обычный лист со строками
        list1.add("S1");
        list1.add("S1");
        list1.add("S1");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("S2");
        list2.add("S2");
        list2.add("S2");
       ArrayList  <String> list3 = new ArrayList<>();
        list3.add("S3");
        list3.add("S3");
        lists[0]=list1;//добавили в массив ArrayList <String>[] lists =new ArrayList[3];
        lists[1]=list2;
        lists[2]=list3;


        return lists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}