package com.javarush.task.task27.task2707;

import java.util.concurrent.locks.ReentrantLock;

/*
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {


        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        boolean flag = false;


        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (o1) {}
//
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {

                solution.someMethodWithSynchronizedBlocks(o1, o2);}



        });

        th1.start();
        th2.start();
        Thread.sleep(2000);
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.tryLock();
        if (th2.getState() == Thread.State.BLOCKED) {
            return true;
        } else return false;


    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
