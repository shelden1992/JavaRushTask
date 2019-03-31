package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;//в переменную сохранить систем.оут
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); //создать поток байтов
        PrintStream printStream = new PrintStream(byteArrayOutputStream); //сделать обертку над байтами
        System.setOut(printStream); //вызвать у класса систем вывод
        testString.printSomething();
        System.setOut(consoleStream);

        System.out.println(byteArrayOutputStream.toString().replaceAll("te", "??"));

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
