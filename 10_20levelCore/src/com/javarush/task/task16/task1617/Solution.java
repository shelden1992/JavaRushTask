package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds=3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock=new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {

            try {
                while (!currentThread().isInterrupted()) {
                    if (countSeconds>3) {
                        while (!currentThread().isInterrupted()) {
                            System.out.print(countSeconds + " ");
                            Thread.sleep(1000);
                            countSeconds--;


                        }
                    }
                    else if (countSeconds == 0) {
                        System.out.println("Марш!");
                        currentThread().interrupt();
                    }
                    else {
                        System.out.print(countSeconds + " ");
                        Thread.sleep(1000);
                        countSeconds--;
                    }     }



            } catch (InterruptedException e1) {
                System.out.println("Прервано!");
            }
        }

                }
            }

