package com.javarush.task.task37.task3710.decorators.exemple;

public class DecorFourChees extends Decor {
    @Override
    public int getCost() {
        return super.pizza.getCost() + 100;
    }

    @Override
    public void setPizza(Pizza pizza) {
        super.setPizza(pizza);
    }

    public DecorFourChees(Pizza pizza) {
        super(pizza);

    }

    @Override
    public String getName() {

        return  super.pizza.getName() + " 4CheessPizza";
    }
}
