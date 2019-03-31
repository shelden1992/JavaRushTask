package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static List<String> result=new ArrayList<String>();
    public static volatile int count = 0;
    public static volatile BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1=new Read3Strings();


        t1.start();

        t1.join();


        Read3Strings t2=new Read3Strings();


        t2.start();

        t2.join();



        t1.printResult();
        t2.printResult();

    }

    public static class Read3Strings extends Thread {
        private String list="";
        @Override
        public void run() {

            try {
//                count++;
                for (int i=0; i < 3; i++  ) {
                    list+=reader.readLine().concat(" ");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void printResult() {
            System.out.print(list);
            System.out.println("");
            }
        }

    }




