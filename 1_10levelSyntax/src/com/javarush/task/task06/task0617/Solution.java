package com.javarush.task.task06.task0617;

/* 
Блокнот для новых идей
*/

public class Solution {
    public static void printIdea(Idea idea){
        System.out.println(Idea.getDescription());
    }
    public static void main(String[] args) {
         printIdea(new Idea());
    }
    public static class Idea{
        public static String getDescription() {
            String s = "заработать 1млн";
            return s;
        }

    }
}
