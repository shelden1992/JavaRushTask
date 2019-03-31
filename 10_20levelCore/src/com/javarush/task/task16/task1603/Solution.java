package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list=new ArrayList<Thread>(5);

    public static void main(String[] args) {


        for (int i=0; i < 5; i++) {
            Thread thread=new Thread(new SpecialThread());
            list.add(thread);
        }

        list.get(0).run();
    }


    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}

