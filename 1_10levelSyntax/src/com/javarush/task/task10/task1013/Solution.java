package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.util.List;

public class Solution {
    public static void main(String[] args) {
    }



    public static class Human {
        private String firstName;
        private String lastName;
        private int age;
        private boolean sex;

        public Human(String firstName) {
            this.firstName=firstName;
        }

        public Human(String firstName, String lastName, List<Children> list) {
            this.firstName=firstName;
            this.lastName=lastName;
            this.list=list;
        }

        public Human(String firstName, String lastName, int age, boolean sex, String profession) {

            this.firstName=firstName;
            this.lastName=lastName;
            this.age=age;
            this.sex=sex;
            this.profession=profession;
        }

        public Human(String firstName, String lastName, int age, String profession) {

            this.firstName=firstName;
            this.lastName=lastName;
            this.age=age;
            this.profession=profession;
        }

        public Human(String firstName, String lastName, String profession) {

            this.firstName=firstName;
            this.lastName=lastName;
            this.profession=profession;
        }

        public Human(String firstName, String lastName) {

            this.firstName=firstName;
            this.lastName=lastName;
        }

        private List<Children> list;

        public Human(String firstName, String lastName, int age) {
            this.firstName=firstName;
            this.lastName=lastName;
            this.age=age;
        }

        public Human(String firstName, String lastName, int age, boolean sex) {

            this.firstName=firstName;
            this.lastName=lastName;
            this.age=age;
            this.sex=sex;
        }

        public Human(String firstName, String lastName, int age, boolean sex, List<Children> list) {

            this.firstName=firstName;
            this.lastName=lastName;
            this.age=age;
            this.sex=sex;
            this.list=list;
        }

        private String profession;

        public Human(String firstName, String lastName, int age, boolean sex, List<Children> list, String profession) {
            this.firstName=firstName;
            this.lastName=lastName;
            this.age=age;
            this.sex=sex;
            this.list=list;
            this.profession=profession;
        }
// напишите тут ваши переменные и конструкторы
    }
}
