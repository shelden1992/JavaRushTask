package com.javarush.task.task35.task3501.SomeWhoLife;

import java.util.ArrayList;
import java.util.List;

public class Mammals  extends Animal{
    public static void main(String[] args) {
        List<Mammals> myList = new ArrayList<>();
        List<Animal> animalList = new ArrayList<>();
        myList.add(new Cat());
        myList.add( new Dog());
        myList.add( new Mouse());
//        myList.add(new Animal());   не компилируется!
        ////////////////////////////////////////////////////////////////////////////
        List<? extends Mammals> myList2 = new ArrayList<>();
//        myList2.add(new Cat());
//        myList2.add( new Dog());
//        myList2.add( new Mouse());
//        myList.add(new Animal());
        myList.add(new Mammals());
       ////////////////////////////////////////////////////////////////////////////
        List<? super Mammals> myList3 = new ArrayList<>();
        myList3.add(new Cat());
        myList3.add( new Dog());
        myList3.add( new Mouse());
        myList3.add(new Mammals());


        ////////////////////////////////////////////////////////////////////////////
        List<? super Animal> myList4 = new ArrayList<>();
        myList4.add(new Cat());
        myList4.add( new Dog());
        myList4.add( new Mouse());
        myList4.add(new Mammals());

        List<? super Dog> dogList = new ArrayList<>();
//        dogList.add(new Mammals());
//        dogList.add(new Animal());
        dogList.add(new Dog());


        List<? extends Animal> myList5 = new ArrayList<>();
//        myList5.add(new Mammals());
//        myList5.add(new Animal());
List<Cat> cats = new ArrayList<>();
List<Dog> dogs = new ArrayList<>();




eats(cats, dogs);
eats(animalList, myList);
socks(animalList, myList);



    }
    public static void eats(List<? extends Animal> animals, List<? extends Animal> animals2 ){

    }
    public static void socks (List<? super Dog> animals, List<? super Cat> animals2 ) {

    }
    }
