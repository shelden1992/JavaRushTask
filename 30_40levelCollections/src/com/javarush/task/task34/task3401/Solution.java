package com.javarush.task.task34.task3401;

/* 
Числа Фибоначчи с помощью рекурсии
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution=new Solution();

//        for (int i=0; i <=9; i++) {


            System.out.println(solution.fibonacci(9));     //34
        System.out.println(solution.fibonacci(5));     //5
        System.out.println(solution.fibonacci(2));     //1
        System.out.println(solution.fibonacci(1));     //1
    }

    public int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
            /*
             fibonacci (4)                                    +                   fibonacci (3)
                    |                                                                   |
                    ^                                                                   ^
                    fibonacci (3)         +         fibonacci (2)                  fib(2) + fib(1)
                       |                                   |                        |          |
                       ^                                   |                        ^          ^
                   fibonacci (2) + fibonacci (1)           |                        1     +    1
                        |              |                   |
                        ^              ^                   |
                        1    +         1          +        1
            */
        }

    }
//                x    y  + (x = sum)      x = sum
//                1,   1,     2,            3,        5,    8,    13//

}
