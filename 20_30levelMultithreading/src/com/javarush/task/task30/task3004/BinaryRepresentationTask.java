package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    int x;

    public BinaryRepresentationTask(int x) {
        this.x=x;
    }

    @Override
    protected String compute() {


        int a=x % 2;
        int b=x / 2;
        BinaryRepresentationTask binaryRepresentationTask=new BinaryRepresentationTask(b);
        binaryRepresentationTask.fork();
        if (b > 0) {//3
            return binaryRepresentationTask.join() + a; //(3) + 0 //(1) + 1// 0 +
        }

        return String.valueOf(a); //1 в конце
    }

}
