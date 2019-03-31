package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

import static com.javarush.task.task27.task2712.ConsoleHelper.getAllDishesForOrder;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    @Override
    public String toString() {

        if (dishes.isEmpty()) {
            return "";
        } else {
            final StringBuilder sb=new StringBuilder("Your order: ");

            sb.append(dishes);

            sb.append(" of ").append(tablet);
            return sb.toString();
        }
    }
//    Your order: [Juice, Fish] of Tablet{number=5}

    public Order(Tablet tablet) throws IOException {
        this.tablet=tablet;
        dishes=getAllDishesForOrder();
    }

    public int getTotalCookingTime() {

        int dishTime=0;




        for (Dish dishess : dishes
        ) {
            dishTime =dishTime +dishess.getDuration();
        }
        return dishTime;
    }
    public boolean isEmpty(){
        return dishes.isEmpty();
    }
}
