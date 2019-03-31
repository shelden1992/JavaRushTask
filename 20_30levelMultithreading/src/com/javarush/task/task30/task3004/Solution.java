package com.javarush.task.task30.task3004;

import java.util.concurrent.ForkJoinPool;

/* 
Fork/Join
*/
public class Solution {
    private String binaryRepresentationMethod(int x) {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a); //0
        if (b > 0) {//3
            return binaryRepresentationMethod(b) + result; //(3) + 0 //(1) + 1// 0 +
        }
        return result; //1 в конце
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String result1 = solution.binaryRepresentationMethod(6);
        System.out.println(result1);

        System.out.println();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        String result2 = forkJoinPool.invoke(new BinaryRepresentationTask(6));
        System.out.println(result2);
    }

}
