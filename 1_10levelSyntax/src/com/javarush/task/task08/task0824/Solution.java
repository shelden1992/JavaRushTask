package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args)  {
        ArrayList<Human>childs  = new ArrayList<>();
        childs.add(new Human("Children1", true,10));
        childs.add(new Human("Children2", true,10));
        childs.add(new Human("Children3", true,10));


        ArrayList<Human>parentsPa  = new ArrayList<>();
        parentsPa.add(new Human("pa", true, 40, childs));


        ArrayList<Human>parentsMa  = new ArrayList<>();
        parentsMa.add(new Human("ma", false,40, childs));

        ArrayList<Human>grand  = new ArrayList<>();

        grand.add(new Human("grenpa", true, 80, parentsMa));
        grand.add(new Human("grenpa2", true, 80, parentsPa));
        grand.add(new Human("grenma", false, 80,parentsMa));
        grand.add(new Human("grenma", false, 80,parentsPa));

        for (Human gr:grand
             ) { System.out.println(gr);

        }





    }

    public static class Human {
        String name;
        boolean sex;

        public Human(String name, boolean sex, int age) {
            this.name=name;
            this.sex=sex;
            this.age=age;
        }

        int age;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.children=children;
        }

        ArrayList<Human> children= new ArrayList<>();

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
