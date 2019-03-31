package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Human>famally = new ArrayList<>();

      Human granpa1 = new Human("granpa1", true,100);
      Human granpa2 = new Human("granpa2", true,100);
      Human granma1 = new Human("granma1", false,100);
      Human granma2 = new Human("granma2", false,100);
        famally.add(granma1);
        famally.add(granma2);
        famally.add(granpa1);
        famally.add(granpa2);
      Human ma = new Human("ma", false,40, granpa1, granma1);
      Human pa = new Human("pa", true,40, granpa2, granma2);
      famally.add(ma);
      famally.add(pa);

       Human children1 = new Human("children1", true,12, pa, ma);
       Human children2 = new Human("children1", true,12,pa, ma);
       Human children3 = new Human("children1", true,12, pa, ma);
famally.add(children1);
famally.add(children2);
famally.add(children3);
        for (Human human: famally
             ) {
            System.out.println(human);

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
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.father=father;
            this.mother=mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















