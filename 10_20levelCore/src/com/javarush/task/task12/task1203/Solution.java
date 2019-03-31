//package com.javarush.task.task12.task1203;
//
///*
//Кесарю — кесарево
//*/
//
//public class Solution {
//    public static void main(String[] args) {
//        Pet pet1 = new Cat();
//        Cat cat = new Pet();                //ссоздали ссылку на обьект класса Cat
//
//        System.out.println(pet1.getChild());
//
//        Pet pet2 = new Dog();
////        String dog = pet2.getChild();
//        System.out.println(pet2.getChild());
//
//    }
//
//    public static class Pet {
//        public String getChild() {
//            return "Я пет";
//        }
//    }
//
//    public static class Cat extends Pet {
//       public Cat getChilds(){
//           return new Cat();
//        }
////    }
//
//    public static class Dog extends Pet {
//        public String getChild(){
//            return "Я собака";
//        }
//
//    }
//}
