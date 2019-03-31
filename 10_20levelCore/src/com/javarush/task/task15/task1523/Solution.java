package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {


    int a;
    String s;
    double d;
    short sh;
    private Solution(int a) {
        this.a=a;
    }

    Solution(int a, String s) {
        this.a=a;
        this.s=s;
    }

    protected Solution(int a, String s, double d) {
        this.a=a;
        this.s=s;
        this.d=d;
    }

    public Solution(int a, String s, double d, short sh) {
        this.a=a;
        this.s=s;
        this.d=d;
        this.sh=sh;
    }

    public static void main(String[] args) {

    }
}

