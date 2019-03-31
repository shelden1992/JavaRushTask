package com.javarush.task.task37.task3710.decorators.exemple;

public class Base2PizzaWithTomato extends Pizza{
    @Override
    public int getCost() {
        return 20;
    }

    @Override
    public String getName() {
        return " 2 base+";
    }
}
