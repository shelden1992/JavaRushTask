package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread theThread;
    private Thread.State nowState;

    public LoggingStateThread(Thread theThread) {
        this.theThread=theThread;
        nowState=theThread.getState();
    }


    @Override
    public void run() {
        Thread.State newState;
        System.out.println(nowState);
        do {
            newState=theThread.getState();
            if (newState != nowState) {
                nowState=newState;
                System.out.println(nowState);
            }
        } while (newState != State.TERMINATED);
    }
}
