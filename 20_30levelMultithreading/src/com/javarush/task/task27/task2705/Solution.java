package com.javarush.task.task27.task2705;

/* 
Второй вариант deadlock
*/
public class Solution {
    private final Object lock = new Object();

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public  void secondMethod() {
        synchronized (lock){
            synchronized (this){
        doSomething();}
        }
    }

    private void doSomething() {
        System.out.println( "я поток номер: " + Thread.currentThread().getName() );
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution solution2 = new Solution();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.firstMethod();

            }

        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution2.secondMethod();

            }
        });
        thread1.start();

        thread2.start();


    }
//    1. Первая нить захватывает мьютекс this.
//2. Вторая нить успевает захватить мьютекс Object lock.
//3. Теперь первая нить будет ждать пока освободится Object lock, а вторая пока освободится мьютекс this. Вот так и будут ждать.
}