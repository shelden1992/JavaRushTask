package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString=new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream consoleStream=System.out;//в переменную сохранить систем.оут
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(); //создать поток байтов
        PrintStream printStream=new PrintStream(byteArrayOutputStream); //сделать обертку над байтами
        System.setOut(printStream); //вызвать у класса систем вывод
        testString.printSomething();
        System.setOut(consoleStream);

        try (BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

             FileOutputStream fileOutputStream=new FileOutputStream(reader.readLine())) {

            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            System.out.println(byteArrayOutputStream.toString());
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

