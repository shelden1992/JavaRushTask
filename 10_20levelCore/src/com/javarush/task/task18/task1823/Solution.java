package com.javarush.task.task18.task1823;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap=new HashMap<String, Integer>();

    public static void main(String[] args) {
        try (Scanner scanner=new Scanner(System.in)) {
            String s="";
            while (!( s=scanner.nextLine() ).equals("exit")) {
                new ReadThread(s).start();

            }
//            System.out.println(resultMap);

        }

    }

    public static class ReadThread extends Thread {

        private final String fileName;

        @Override
        public void run() {
            byte[] b=new byte[0];
            try (FileInputStream byteArrayInputStream=new FileInputStream(fileName)) {
                while (byteArrayInputStream.available() > 0) {
                    b=new byte[byteArrayInputStream.available()];
                    byteArrayInputStream.read(b);

                }
//                synchronized (this) {


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


//                }



            Map<Byte, Integer> localMapFromFindByte=new HashMap<>();
            int ind=1;
            for (Byte byt : b
            ) {
                if (!localMapFromFindByte.containsKey(byt)) {
                    localMapFromFindByte.put(byt, ind);
                } else {
                    int count=localMapFromFindByte.get(byt) + 1;
                    localMapFromFindByte.put(byt, count);


                }
            }

            Map.Entry<Byte,Integer>  enFirst = null;
            for (Map.Entry<Byte, Integer> ent : localMapFromFindByte.entrySet()) {
                if (enFirst!=null) {
                    if    (ent.getValue() > enFirst.getValue()){
                        enFirst=ent;


                    }
                }
                else enFirst =ent;

            }


            synchronized (this){
                resultMap.put(fileName, Integer.valueOf(enFirst.getKey()));
//                stringMapMap.put(fileName, localMapFromFindByte);
            }
        }




        public ReadThread(String fileName) {
            this.fileName=fileName;


        }
    }

}