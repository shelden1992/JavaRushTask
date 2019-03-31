package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> bytes=new ArrayList<>();

//
//        Scanner scanner=new Scanner(System.in);
//        String nameFile=scanner.nextLine();
//        scanner.close();

        int date2=0;
        FileInputStream in=null;
        int date=0;
        char c;
        try {
            in=new FileInputStream(args[0]);
            while (in.available() > 0) {
                date=in.read();
                bytes.add(date);

            }
            TreeMap<Integer, Integer> map=new TreeMap<>();//посчитаны ключи, значение - это коунт
            for (Integer ins : bytes
                    ) {
//                if (!ins.equals("\n") || !ins.equals(" ")) {
                if (map.containsKey(ins)) {
                    map.put(ins, map.get(ins) + 1);
                } else
                    map.put(ins, 1);


            }

            in.close();
//            }

            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                int a=pair.getKey();
                char b=(char) a;
                System.out.println(b + " " + pair.getValue());


            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}


