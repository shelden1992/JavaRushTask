package com.javarush.task.task16.task1632;

public class FourthThread extends Thread implements Message {
    @Override
    public void showWarning() {

        this.interrupt();
        try {
            this.join();
        } catch (Exception e) {

        }

    }

    @Override
    public void run() {
        Thread current=Thread.currentThread();
        while (!current.interrupted()) {

        }


    }

//    Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
}
