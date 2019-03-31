package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class VeryComplexClass {
    public   void veryComplexMethod() throws Exception {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("sad"));
    }

    public static void main(String[] args) {

    }
}
