package com.javarush.task.task16.task1626;

public class Solution {
    public static int number=5;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new CountDownRunnable(), "Уменьшаем").start();
        Thread.sleep(2500);
        new Thread(new CountUpRunnable(), "Увеличиваем").start();

    }

    public static class CountUpRunnable implements Runnable {
        private int countIndexUp=Solution.number - (Solution.number- 1) ;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(toString());
                countIndexUp+=1;
                if (countIndexUp == Solution.number + 1) {

                    return;
                }

            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }
    }


    public static class CountDownRunnable implements Runnable {
        private  int countIndexDown=Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown-=1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
//                    Solution.number = countIndexDown;

                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
