package com.javarush.task.task37.task3710.decorators.exemple;

public class DecorMarcharPizza extends Decor{
    public DecorMarcharPizza(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return super.pizza.getCost() + 50;
    }

    @Override
    public void setPizza(Pizza pizza) {
        super.setPizza(pizza);

    }

    @Override
    public String getName() {
        return super.pizza.getName()+  " PizzaMarchar";
    }
}
