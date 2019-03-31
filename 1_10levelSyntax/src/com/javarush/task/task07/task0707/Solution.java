package com.javarush.task.task07.task0707;

import java.util.ArrayList;
import java.util.List;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String>list  = new ArrayList<>();
         list.add ("sew");
         list.add (1,"awe");
         list.add (2,"qwww");
         list.add (3,"wwq");
         list.add (4,"wwwa");
        System.out.println(list.size());
         for (int i = 0; i< list.size(); i++)


        System.out.println( list.get(i));
    }
}
