package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> set=new HashSet<>();
        StringBuilder stringBuilder;
        StringBuilder reverseStringBuilder=new StringBuilder();
        try {
            for (int i=2; i <= 36; i++) {
                try {
//                    Integer temp=Integer.parseInt(number, i);
                    String tempString=Integer.toString(Integer.parseInt(number), i);


                    reverseStringBuilder=new StringBuilder().append(tempString).reverse();

                    if (reverseStringBuilder.toString().equals(tempString)) {
                        set.add(i);
                    }
                } catch (Exception e) {
                    continue;
                }
            }

        } catch (NumberFormatException e) {
            return set=null;
        }
        return set;
    }
}