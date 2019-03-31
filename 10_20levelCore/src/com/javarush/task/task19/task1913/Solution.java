package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;//в переменную сохранить систем.оут
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); //создать поток байтов
        PrintStream printStream = new PrintStream(byteArrayOutputStream); //сделать обертку над байтами
        System.setOut(printStream); //вызвать у класса систем вывод
        testString.printSomething();
        System.setOut(consoleStream);

        System.out.println( byteArrayOutputStream.toString().replaceAll("[^0-9]+", ""));

    }


    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
