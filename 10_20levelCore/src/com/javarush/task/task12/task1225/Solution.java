package com.javarush.task.task12.task1225;

/* 
Посетители
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {


          if (o instanceof Tiger) {//Animal-->Cat-->Tiger
            return "Тигр";
        }

        else   if (o instanceof Lion) {
            return "Лев";
        }

        else   if (o instanceof Bull) {
            return "Бык";

        }

        else   if (o instanceof Cow) {
            return "Корова";

        }
       else if (o instanceof Cat) {
            return "Кот";

        }



        return "Животное";
    }
    //трассируя код), любой тип который имеет родителя, наследует все типы по родительскому дереву.
    // И при сравнении идет перебор от самого "глубокого" до самого "поверхностного" типа.
    // И в переменную выносится верхний правильный (из дерева).
    //
    //Animal -> Cat -> Tiger
    //
    //так к примеру для тигра: сначала код воспринимает аргумент метода как животное,
    // потом как кошку и только потом как тигр ( соответственно на каждом этапе переприсваивая значение sss).
    // последнее значение и остается для возврата.

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Animal {
    }
}
