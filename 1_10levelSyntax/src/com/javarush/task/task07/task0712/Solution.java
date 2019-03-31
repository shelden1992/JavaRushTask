package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int max=0;
        int min=Integer.MAX_VALUE;
        int countMax=0;
        int countMin=0;
        List<String> array=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);


       for (int i =0; i<10; i++) {
           String s=scanner.nextLine();

           array.add(i, s);
       }
        for (int i=0; i < array.size(); i++) {
            if (array.get(i).length() > max) {
                max=array.get(i).length();
                countMax=i;
            }
        }
        for (int i=0; i < array.size(); i++) {
            if (array.get(i).length() < min) {
                min=array.get(i).length();
                countMin=i;
            }

        }
        if(countMax>countMin){
            System.out.println(array.get(countMin));
        }
        else System.out.println(array.get(countMax));
    }
}
