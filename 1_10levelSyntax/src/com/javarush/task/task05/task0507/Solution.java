package com.javarush.task.task05.task0507;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        double c = 0;
        while (true){

            double i = Integer.parseInt(bufferedReader.readLine());

            if (i == -1){
                if (i==-1 && n==0){
                    System.out.println("КОНЕЦ");
                    break;}
                break;}

            c+=i;
            n+=1;
        }

        System.out.println(c/n);

    }
}

