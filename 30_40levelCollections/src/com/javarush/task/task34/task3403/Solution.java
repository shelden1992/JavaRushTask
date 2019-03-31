package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
132/2
      66/2
           33/3
               11

Вывод на консоль:
2 2 3 11
*/

public class Solution {
    public   void recursion(int n) {
        int a=2;
        if (( n <= 1 )) {

        }


        while (a <= n) {

            if (( n ) % ( a ) == 0) {
                if (a != n) {
                    System.out.print(a + " ");
                    recursion(n / a);
                } else {
                    System.out.println(a);


                }
                return;
            }

            a++;
        }
    }

}
