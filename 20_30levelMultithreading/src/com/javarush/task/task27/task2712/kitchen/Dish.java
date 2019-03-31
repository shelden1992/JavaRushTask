package com.javarush.task.task27.task2712.kitchen;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum Dish {


    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    public int getDuration() {
        return duration;
    }

    Dish(int duration) {
        this.duration = duration;

    }

    public static String allDishesToString() {
        EnumSet<Dish> allDishes=EnumSet.allOf(Dish.class);
        List<Dish> list=new ArrayList<Dish>(allDishes.size());
        list.addAll(allDishes);

        return String.valueOf(list);
    }
}
