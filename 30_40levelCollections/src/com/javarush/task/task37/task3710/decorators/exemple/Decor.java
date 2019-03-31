package com.javarush.task.task37.task3710.decorators.exemple;

public abstract class Decor extends Pizza {
      Pizza pizza;

    public void setPizza (Pizza pizza){
        this.pizza = pizza;
    }




    @Override
    public abstract int getCost();

    public Decor(Pizza pizza) {
        this.pizza=pizza;
    }

    @Override
    public abstract String getName();
}
