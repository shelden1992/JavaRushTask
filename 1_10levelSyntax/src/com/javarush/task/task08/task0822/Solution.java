package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* 
Минимальное из N чисел
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        List<Integer> integerList=getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {

        int max = Integer.MIN_VALUE;
        //System.out.println(Integer.MAX_VALUE) дает 2147483647
        //System.out.println(Integer.MIN_VALUE) дает -2147483648
        int min = Integer.MAX_VALUE;

        for (int i=0; i < array.size(); i++) {
            if (array.get(i) < min) {
                min=array.get(i);
            }

        }

        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {

        //create and initialize a list here - создать и заполнить список тут
        Scanner scanner=new Scanner(System.in);
        System.out.println("Размер:");
        int x=Integer.parseInt(scanner.nextLine());

        List<Integer> array=new ArrayList<>(x);
        System.out.println("Введите массив цифр");
        for (int i=1; i <= x; i++) {
            int z=scanner.nextInt();

            array.add(z);
        }
        return array;

    }
}
