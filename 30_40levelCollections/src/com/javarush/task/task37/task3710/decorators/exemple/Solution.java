package com.javarush.task.task37.task3710.decorators.exemple;

public class Solution {
    public static void main(String[] args) {
        Pizza pizza = new DecorFourChees(new Base1PizzaWithTomato());
        System.out.println(pizza.getCost() + pizza.getName());
        Pizza pizza1 = new DecorMarcharPizza(new Base2PizzaWithTomato());
        System.out.println(pizza1.getCost()+ pizza1.getName());
        Pizza pizza2 =new DecorFourChees(new Base2PizzaWithTomato());
        System.out.println(pizza2.getCost()+ pizza2.getName());
        System.out.println(new DecorSeaPizza(new Base1PizzaWithTomato()).getCost());
    }
}
