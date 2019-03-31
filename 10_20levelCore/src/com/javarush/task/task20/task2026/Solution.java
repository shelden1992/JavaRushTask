package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1=new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2=new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1=getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2=getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        byte[][] newArray=new byte[a.length+1][a.length+1];
        for (int i=0; i < a.length; i++) {
            if (a[i].length >= 0) System.arraycopy(a[i], 0, newArray[i], 0, a[i].length);

        }


        int count=0;

        for (int i=0; i < newArray.length; i++) {
            for (int j=0; j < newArray[i].length; j++) {
                try {
                    if (newArray[i][j] == 1) {
                        if (newArray[i + 1][j] == 0) {
                            if (newArray[i][j + 1] == 0) {
                                count++;
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    count++;
                }


            }

        }


        return count;
    }
}
