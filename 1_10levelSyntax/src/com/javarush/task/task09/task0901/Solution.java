package com.javarush.task.task09.task0901;

/* 
Возвращаем StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
//        StackTraceElement[] StackTrace = Thread.currentThread().getStackTrace();
//        System.out.println(StackTrace[2].getMethodName());
        //В стеке всегда метод вызвавший StackTrace, будет на позиции[2].
        //
        //0 - getStackTrace
        //
        //1 - имя метода (свое имя)
        //
        //2 - имя метода кто вызвал [1]
        //
        //3 - имя метода кто вызвал [2]
        //
        //4 - и т.д.
        //
        //Мы тут видим прошлое, что происходило до запуска текущего методa.

    }

    public static StackTraceElement[] method1() {
        method2();
        StackTraceElement[] StackTrace = Thread.currentThread().getStackTrace();
        System.out.println(StackTrace[2].getMethodName());
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method2() {
        method3();
        StackTraceElement[] StackTrace = Thread.currentThread().getStackTrace();
        System.out.println(StackTrace[2].getMethodName());
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method3() {
        method4();
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method4() {
        method5();
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method5() {
        return Thread.currentThread().getStackTrace();
    }
}
