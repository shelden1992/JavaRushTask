package com.javarush.task.task13.task1311;

/* 
Нанимаем переводчика
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        EnglishTranslator englishTranslator = new EnglishTranslator();
        System.out.println(englishTranslator.translate());
    }

    public static abstract class Translator {//имеется какй-то абстрактный класс переводчика
        public abstract String getLanguage();//и есть у него свойство(метод) переводить с какого-то языка

        public String translate() {
            return "Я переводчик с " + getLanguage();
        }
    }

    public static class EnglishTranslator extends Translator {
        @Override
        public String getLanguage() {
            return "английского";
        }
    }

}