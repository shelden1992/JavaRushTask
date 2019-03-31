package com.javarush.task.task09.task0923;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/* 
Гласные и согласные
*/

public class Solution {


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        char[] c;
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        ArrayList<String> arrayVowels = new ArrayList<>();
        ArrayList<String> arrayNoVowels = new ArrayList<>();
        String a;


        StringTokenizer st = new StringTokenizer(word, " \t\n\r");

        while (st.hasMoreTokens())                      //запускаем цикл вывода слов из токена
        {
            a = st.nextToken();                         //присваиваем переменной стринг слово из токена
            c = a.toCharArray();                        //разбиваем слово на посимвольный char-массив

            for (char aC : c) {
                boolean vowel = isVowel(aC);
                if (vowel) {
                    arrayVowels.add(String.valueOf(aC));
                } else {
                    arrayNoVowels.add(String.valueOf(aC));
                }
            }


        }
        for (String w : arrayVowels)
        {
            System.out.print(w + " ");
        }
        System.out.println();
        for (String w1 : arrayNoVowels)
        {
            System.out.print(w1 + " ");
        }
    }

        // метод проверяет, гласная ли буква
        public static boolean isVowel ( char c){
            c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

            for (char d : vowels)   // ищем среди массива гласных
            {
                if (c == d)
                    return true;
            }
            return false;
        }
    }