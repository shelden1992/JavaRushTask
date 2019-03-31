package com.javarush.task.task37.task3710.decorators.exemple;

public class Base1PizzaWithTomato extends Pizza {
    @Override
    public int getCost() {
        return 25;
    }

    @Override
    public String getName() {
        return " 1 base+";
    }
}
