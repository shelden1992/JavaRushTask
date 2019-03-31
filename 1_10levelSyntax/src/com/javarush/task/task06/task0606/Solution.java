package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;
    static int z=0;

    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        Integer x=Integer.parseInt(scanner.nextLine());
        int nummer=x;
//        System.out.println(Math.ceil(Math.log10(x)));
        if (x > 10) {
            for (int i=0; i < Math.ceil(Math.log10(nummer)); i++) {
                int z=x % 10; //12-->2/ 11-->1
                if (z % 2 == 0)
                    even++;
                else odd++;
                x=x / 10;

            }
        } else if (x % 2 == 0) {
            even++;

        } else odd++;

        System.out.println("Even: " + even + " Odd: " + odd);

    }
}
