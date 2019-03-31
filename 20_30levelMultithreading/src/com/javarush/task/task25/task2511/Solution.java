package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;


    public Solution(TimerTask original) {
        class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (t.getName().length()>0){
                StringBuilder s =new StringBuilder();
                for(int i =0; i<t.getName().length();i++){
                    s.append("*");
                }
//                t.setName(String.valueOf(s));
                System.out.format(    t.getName()+ e.getMessage());}
            }
        }


        this.handler =  new UncaughtExceptionHandler();     //init handler here
        this.original = original;
        if (original == null) {
            throw new NullPointerException();
        }
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
//        Solution solution = new Solution(original);
    }
}