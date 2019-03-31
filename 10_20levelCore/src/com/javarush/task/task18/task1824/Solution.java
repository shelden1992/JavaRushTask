package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<BufferedReader> list = new ArrayList<>();
boolean flag = false;
        while (!flag){
        String nameFile= scanner.nextLine();
            try (BufferedReader bufferedReader=new BufferedReader(new FileReader(new File(nameFile)))) {
            list.add(bufferedReader);
            }

            catch (FileNotFoundException e){
                System.out.println(  nameFile);
                scanner.close();
flag=true;
            }
            }
        }

    }

