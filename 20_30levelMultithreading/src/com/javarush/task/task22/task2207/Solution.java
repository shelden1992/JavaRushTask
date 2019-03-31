package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result=new LinkedList<>();

    public static void main(String[] args) throws IOException {


        try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bufferedReader1=new BufferedReader(new FileReader(bufferedReader.readLine()))) {

            String nameFile;
            StringBuilder stringBuilder=new StringBuilder();
            while (( nameFile=bufferedReader1.readLine() ) != null) {
                stringBuilder.append(nameFile);//строки через пробел
                stringBuilder.append(" ");
            }
            System.out.println(stringBuilder.toString());
            String temp = stringBuilder.toString().replaceAll("(\\r)?\\n", "");
            stringBuilder = new StringBuilder(temp);

            List<String> list=new ArrayList<>();
            Pattern p=Pattern.compile("\\b\\S+\\b");
            Matcher m=p.matcher(stringBuilder);
            while (m.find()) {
                list.add(m.group());
//                System.out.println(m.group());
            }


            for (int i=0; i < list.size() - 1; i++) {

                for (int j=i + 1; j < list.size(); j++) {

                    String second=new StringBuilder(list.get(j)).reverse().toString();

                    if (list.get(i).equals(second)) {
                        result.add(new Pair(list.get(i), new StringBuilder(list.get(j)).toString()));
                        list.remove(i);
                    }
                }

            }


        }

        System.out.println(result);
    }


//            System.out.println(map);


    public static class Pair {
        public Pair() {
        }

        String first;
        String second;

        public Pair(String first, String second) {
            this.first=first;
            this.second=second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair=(Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result=first != null ? first.hashCode() : 0;
            result=31 * result + ( second != null ? second.hashCode() : 0 );
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }
}


