package com.javarush.task.task13.task1315;

/* 
Том, Джерри и Спайк
*/

public class Solution {
    public static void main(String[] args) {
       Animal dog = new Dog("Spayk", 15, 1);
       Animal cat = new Cat( "Tom", 16, 2);
        Animal mouse = new Mouse("Jerry", 17, 3);

    }
    //может двигаться
    public interface Movable {

        double speed (double a);
        }


    //может быть съеден
    public interface Eatable {//сьеден
        void eaten();
    }

    //может кого-нибудь съесть
    public interface Eat { //есть
        void eat();
    }

    public static abstract class Animal{
        String name;
        double speed;
        int live;

        public Animal(String name, double speed, int live) {
            this.name=name;
            this.speed=speed;
            this.live=live;
        }
    }
    public static class Dog extends Animal  implements Movable,Eat{


        public Dog(String name, double speed, int live) {
            super(name, speed, live);
        }

        @Override
        public double speed(double a) {
            return a;
        }

        @Override
        public void eat() {

        }
    }
    public static class Cat  extends Animal implements Movable,Eat,Eatable{


        public Cat(String name, double speed, int live) {
            super(name, speed, live);
        }

        @Override
        public void eaten() {

        }

        @Override
        public void eat() {

        }

        @Override
        public double speed(double a) {
            return a;
        }
    }
    public static class Mouse extends Animal implements Movable,Eatable{


        public Mouse(String name, double speed, int live) {
            super(name, speed, live);
        }

        @Override
        public void eaten() {

        }


        @Override
        public double speed(double a) {
            return a;
        }
    }
}