package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {

        for (int i=0; i < threads.length; i++) {
            switch (threads[i].getState()){
                case NEW:{threads[i].start();
                break;}
                case RUNNABLE:{
                    threads[i].isInterrupted();
                    break;}
                case TIMED_WAITING: {threads[i].interrupt();
                break;}
                case WAITING: {threads[i].interrupt();
                break;}

                case BLOCKED:{ threads[i].interrupt();
                break;}
                case TERMINATED:{
                    System.out.println(threads[i] .getPriority());
                    break;}
            }
        }

    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[6];
        threads[0] = new Thread();
        threads[1] = new Thread();
        threads[2] = new Thread();
        threads[3] = new Thread();
        threads[4] = new Thread();
        threads[5] = new Thread();

        processThreads(threads);


    }
}
