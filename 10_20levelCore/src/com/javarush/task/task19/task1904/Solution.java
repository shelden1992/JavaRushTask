package com.javarush.task.task19.task1904;

/*
И еще один адаптер
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        PersonScannerAdapter personScannerAdapter=new PersonScannerAdapter(new Scanner(new FileInputStream("/Users/macuser/Desktop/мама/allFilesContent.txt")));
        System.out.println(personScannerAdapter.read());
        personScannerAdapter.close();

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner=fileScanner;
        }

        @Override
        public Person read() throws ParseException {

           

               SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd MM yyyy");




               String [] st=fileScanner.nextLine().split("\\s", 4);

               System.out.println(Arrays.toString(st)  );



            return  new Person(st[1], st[2], st[0], simpleDateFormat.parse(st[3]));

//             Метод read() класса PersonScannerAdapter должен читать строку с файла,
//             парсить её, и возвращать данные только одного человека, в виде объекта класса Person.
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}
