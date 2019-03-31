package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {


        try {
            int regix=0;
            String s=args[0];


            if (!s.matches("^[0-9a-zA-Z]+$")) {
                System.out.println("incorrect");
                return;
            } else {
                for (int a=2; a <= 37; ) {
                    try {
                        new BigInteger(s, a);
                        regix=a;
                        break;
                    } catch (Exception e) {
                        a++;
                        continue;
                    }

                }
                System.out.println(regix);


            }


        } catch (
                Exception e) {
            System.out.println("incorrect");

        }
    }

}






