package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {


        public String name;
        public int age;
        public int weight;
        public int strength;

        public Cat() {

        }

         public boolean fight (Cat anotherCat) {


           if (this.strength > anotherCat.strength)
                return true;
else
             return false;
        }



        public static void main(String[] args) {
            Cat cat1 = new Cat();
            Cat anotherCat = new Cat();
            anotherCat.fight(cat1);
            cat1.fight(anotherCat);

            cat1.name = "Nick";
            cat1.age = 5;
            cat1.weight = 10;
            cat1.strength =100;


            anotherCat.name = "Klinton";
            anotherCat.age = 6;
            anotherCat.weight = 5;
            anotherCat.strength =103;

            System.out.println ();
        }

    }

