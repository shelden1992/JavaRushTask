package com.javarush.task.task26.task2612;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    //    private
    private Lock lock = new ReentrantLock();


    public void someMethod() {


        try {
            if (lock.tryLock()) {//он ждет если лок захвачен и возвращает true (если свободен)
                ifLockIsFree();

            } else ifLockIsBusy();
        }  catch (Exception e){
            lock.unlock();}
    }


    public void ifLockIsFree() {
    }

    public void ifLockIsBusy() {
    }
}
