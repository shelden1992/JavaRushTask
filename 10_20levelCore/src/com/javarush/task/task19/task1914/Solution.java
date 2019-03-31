package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString=new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream=System.out;//в переменную сохранить систем.оут
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(); //создать поток байтов
        PrintStream printStream=new PrintStream(byteArrayOutputStream); //сделать обертку над байтами
        System.setOut(printStream); //вызвать у класса систем вывод
        testString.printSomething();
        System.setOut(consoleStream);
        String[] s;

      s=byteArrayOutputStream.toString().split(" ");
        for (String str : s) {


            switch (str) {
                case "+":
                    for (int i=0; i < s.length - 1; i++) {
                        if (s[i].matches("-?\\d+")) {
                            Integer a=Integer.parseInt(s[i]);


                            for (int n=i + 1; n < s.length - 1; n++) {
                                if (s[n].matches("-?\\d+")) {
                                    Integer b=Integer.parseInt(s[n]);

                                    int c=a + b;
                                    System.out.println(a + " + " + b + " = " + c);

                                }
                            }
                        }
                    }
                    break;

            case "-":
                for (int i=0; i < s.length - 1; i++) {
                if (s[i].matches("-?\\d+")) {
                    Integer a=Integer.parseInt(s[i]);


                    for (int n=i + 1; n < s.length - 1; n++) {
                        if (s[n].matches("-?\\d+")) {
                            Integer b=Integer.parseInt(s[n]);

                            int c=a - b;
                            System.out.println(a + " - " + b + " = " + c);

                        }
                    }
                }
            }
                break;
                case "*":
                    for (int i=0; i < s.length - 1; i++) {
                        if (s[i].matches("-?\\d+")) {
                            Integer a=Integer.parseInt(s[i]);


                            for (int n=i + 1; n < s.length - 1; n++) {
                                if (s[n].matches("-?\\d+")) {
                                    Integer b=Integer.parseInt(s[n]);

                                    int c=a * b;
                                    System.out.println(a + " * " + b + " = " + c);

                                }
                            }
                        }
                    }
                    break;

            }
        }
    }

        public static class TestString {
            public void printSomething() {
                System.out.println("3 + 6 = ");
            }
        }

}

