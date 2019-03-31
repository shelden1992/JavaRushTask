package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    private static final AtomicInteger fabricNumber=new AtomicInteger(0);
    private static final AtomicInteger threadNumber=new AtomicInteger(0);


    public static void main(String[] args) {


        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group=new ThreadGroup("firstGroup");
        Thread thread=new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2=new ThreadGroup("secondGroup");
        Thread thread2=new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory=new AmigoThreadFactory();
        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        String group=Thread.currentThread().getThreadGroup().getName();
        private static int count;
        private int id=++count;
        private int t_count;

        @Override
        public Thread newThread(Runnable r) {

//
            String GN=Thread.currentThread().getThreadGroup().getName();
            String t_name=String.format("%s-pool-%d-thread-%d", GN, id, ++t_count);
            Thread thread=new Thread(r, t_name);
            if (thread.isDaemon()) {
                thread.setDaemon(false);

            }
            if (thread.getPriority() != Thread.NORM_PRIORITY) {
                thread.setPriority(Thread.NORM_PRIORITY);
            }
            return thread;

        }
    }
}
