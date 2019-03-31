package com.javarush.task.task15.task1526;

/* 
Дебаг, дебаг, и еще раз дебаг
*/

public class Solution {
    public static void main(String[] args) {
//        new A (6);
        new B (6);


    }

    protected static class A {
        protected int f1 = 7;

        public A(int f1) {
            this.f1 = f1;
            initialize();}


        private void initialize() {
            System.out.println(f1);
        }
    }

    protected static class B extends A {
        protected int f1 = 3;

        public B(int f1) {
            super(f1);
            this.f1 += f1;
            initialize();
        }

        public void initialize() {
            System.out.println(f1);
        }
    }
}
