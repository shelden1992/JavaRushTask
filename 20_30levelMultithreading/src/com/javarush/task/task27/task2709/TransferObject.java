package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while (!isValuePresent) {  //пока флаг у нас false выполняем
            // продуцент поменял флаг и выходиим из цикла,
//            при этом освобождаем нить
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Got: " + value);   // берем

        isValuePresent = false;  //меняем флаг

        try {
            return value;
        } finally {
            notifyAll();//  // освобождаем нить, которая в продуценте
        }
    }

    public synchronized void put(int value) {

        while (isValuePresent) {
            try {
                this.wait();    //и ждем
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

        this.value = value;
        System.out.println("Put: " + value);

        isValuePresent = true;  // меняем флаг
        notifyAll(); //во первых освобождаем все wait


    }


}
