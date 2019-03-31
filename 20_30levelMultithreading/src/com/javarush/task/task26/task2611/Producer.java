package com.javarush.task.task26.task2611;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private final AtomicInteger counter = new AtomicInteger();
    int i;
    String value = "Some text for %d";

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    private ConcurrentHashMap<String, String> map;

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();

        try {
        while (!currentThread.isInterrupted()) {



//                i = counter.incrementAndGet();

            ++i;
                map.put(String.valueOf(i), String.format(value, i));
                Thread.sleep(500);


            }} catch (InterruptedException e) {
                System.out.println(String.format("[%s] thread was terminated", currentThread.getName()));
            }




    }
}


