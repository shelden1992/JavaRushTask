package com.javarush.task.task18.task1803;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> bytes=new ArrayList<>();


        Scanner scanner=new Scanner(System.in);
        String nameFile=scanner.nextLine();
        scanner.close();

        int date2=0;
        File file=null;
        FileInputStream in=null;
        int date=0;
        try {
            file=new File(nameFile);
            in=new FileInputStream(file);

            while (in.available() > 0) {
                date=in.read();
                bytes.add(date);

            }
            HashMap<Integer, Integer> map=new HashMap<>();
            for (Integer ins : bytes
                    ) {
                if (map.containsKey(ins)) {
                    map.put(ins, map.get(ins) + 1);
                } else
                    map.put(ins, 1);


            }
//            System.out.println(map);
//            List list = new ArrayList(map.entrySet());
//            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//                @Override
//                public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
//                    return b.getValue() - a.getValue();
//                }
//            });
            in.close();
            if (map.size() <= 0) {
                return;
            }
            else {
                int max=Collections.max(map.values());
                for (HashMap.Entry<Integer, Integer> pair : map.entrySet()) {

                    if (pair.getValue() == max) {
                        System.out.print(pair.getKey() + " ");
//                        map.remove(max);
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }


}

