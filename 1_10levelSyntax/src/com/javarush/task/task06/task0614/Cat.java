package com.javarush.task.task06.task0614;

/*
Статические коты
*/

import java.util.ArrayList;

public class Cat {
   public   static ArrayList<Cat> cats = new ArrayList<>();
    public Cat() {
    }

    public static void main(String[] args) {
        for (int i=0; i <10 ; i++) {
            cats.add(new Cat());

        }
        printCats();
    }

    public static void printCats() {
        for (Cat cats: cats
             ) {
            System.out.println(cats);

        }
    }
}
