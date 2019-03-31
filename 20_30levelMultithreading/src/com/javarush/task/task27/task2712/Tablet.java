package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.javarush.task.task27.task2712.ConsoleHelper.writeMessage;


//Observable (магазин) или Издатель
public class Tablet extends Observable {
    private Observer cook;
    private AdvertisementManager advertisementManager;



    final int number; //это номер планшета
    private static Logger logger=Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number=number;
    }

    @Override
    public String toString() {
        final StringBuilder sb=new StringBuilder("Tablet{");
        sb.append("number=").append(number);
        sb.append('}');
        return sb.toString();
    }

    public Order createOrder() { //cоздавать заказ из тех блюд, которые выберет пользователь.
        Order order=null;
        AdvertisementManager advertisementManager ;


        try {
            order=new Order(this);

            writeMessage(order.toString());

            advertisementManager = new AdvertisementManager(order.getTotalCookingTime()*60);
            try {

               advertisementManager.processVideos();
           }
           catch (NoVideoAvailableException e){
               logger.log(Level.INFO, "No video is available for the order " + order);

           }




        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");

        }
        setChanged();
        if (!order.isEmpty()) {


            notifyObservers(order);
        }

        return order;
    }


//
//    @Override
//    public void removeListener(InvalidationListener listener) {
//
//    }

}
