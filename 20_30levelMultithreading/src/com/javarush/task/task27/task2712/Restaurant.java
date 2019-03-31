package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Cook cook=new Cook("Denia");
        Waiter waiter=new Waiter();

        Tablet tablet=new Tablet(1);

        tablet.addObserver(cook);

        cook.addObserver(waiter);
        Order order=tablet.createOrder();


//        cook.update(tablet, order);

    }


}


