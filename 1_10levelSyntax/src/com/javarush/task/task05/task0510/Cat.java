package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
String name;
int weight=1;
int age =2;
String address= "Набережная25";
String color= "Синий";

public void initialize (String name){
    this.name = name;
    this.weight = 4;
    this.age = 3;
    this.color = "Синий";
    this.address = null;
}
    public void initialize (String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
        this.address = null;
    }


public void initialize (String name, int age){
    this.name = name;
    this.weight = 4;
    this.age = 3;
    this.color = "Синий";
    }

    public void initialize ( int weight, String color){
    this.name = null;
    this.weight = weight;
        this.age = age;
        this.color = color;
        this.address = null;
    }

    public void initialize ( int weight, String color,String address){
        this.weight = weight;
        this.age = age;
        this.color = color;
        this.address = address;
    }


    public static void main(String[] args) {

    }
}
