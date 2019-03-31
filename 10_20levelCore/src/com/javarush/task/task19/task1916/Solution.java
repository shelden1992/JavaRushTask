package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines=new ArrayList<LineItem>();
    public static List<String> linesFile1=new ArrayList<>();
    public static List<String> linesFile2=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in))) {
            String fileReader1=bufferedReader.readLine();
            String fileReader2=bufferedReader.readLine();
            String pathWrite=bufferedReader.readLine();
            String stringFile1;
            String stringFile2;

            try (BufferedReader buffFile1=new BufferedReader(new FileReader(fileReader1))) {
                while (( stringFile1=buffFile1.readLine() ) != null) {
                    linesFile1.add(stringFile1);
                }
            }


            try (BufferedReader buffFile2=new BufferedReader(new FileReader(fileReader2))) {
                while (( stringFile2=buffFile2.readLine() ) != null) {
                    linesFile2.add(stringFile2);
                }


            }

            for (int i=0; i < linesFile1.size(); i++) {
                if (linesFile1.get(i).isEmpty()&&!linesFile2.get(i).isEmpty()) {
                    lines.add(new LineItem(Type.ADDED, linesFile2.get(i)));

                } else if (linesFile1.get(i).isEmpty() && linesFile2.get(i).isEmpty()) {
                    lines.add(new LineItem());

                } else if (linesFile1.get(i).equals(linesFile2.get(i)) && !linesFile1.get(i).isEmpty()) {
                    lines.add(new LineItem(Type.SAME, linesFile1.get(i)));

                } else if (linesFile2.get(i).isEmpty()&&!linesFile1.get(i).isEmpty()) {
                    lines.add(new LineItem(Type.REMOVED, linesFile1.get(i)));
                }
            }


            try (BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(pathWrite))) {
                for (Object s : lines
                        ) {
//                    System.out.println(s);
                    bufferedWriter.write(s + "\n");
                }

            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME,          //без изменений

    }

    public static class LineItem {
        public Type type;
        public String line;


        public LineItem(Type type, String line) {
            this.type=type;
            this.line=line;
        }

        public LineItem() {

        }

        public LineItem(String s) {

        }

        @Override
        public String toString() {
            final StringBuilder sb=new StringBuilder();

                sb.append("").append(type);

                sb.append(" ").append(line).append("");
                sb.append("");

            return sb.toString();

        }

    }
}

