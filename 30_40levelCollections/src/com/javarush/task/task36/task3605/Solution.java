package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader=new BufferedReader(new FileReader(args[0]))) {
            String s="";
            Set<Character> treeSet=new TreeSet<>();
            while (( s=bufferedReader.readLine() ) != null) {
                char[] arrayCharWithPoint=s.toLowerCase().toCharArray();
                for (Character ch : arrayCharWithPoint
                ) {
                    if (ch.toString().matches("[a-zA-Z]")) {
                        treeSet.add(ch);
                    }

                }
            }
            Iterator<Character> characterIterator=treeSet.iterator();
            int count=0;
            while (characterIterator.hasNext() && count < 5) {
                System.out.print(characterIterator.next());
                count++;
            }


        }
    }
}
