package com.javarush.task.task27.task2712.kitchen;

import javafx.beans.Observable;

import java.util.Observer;

import static com.javarush.task.task27.task2712.ConsoleHelper.writeMessage;

//Observer  (покупатель)  |подписчик| для таблета;
// Observable но |издатель| для офика

public class Cook extends java.util.Observable  implements Observer {

    private Observable tablet;
    private String name;

    public Cook(String name) {
        this.name=name;
    }

    @Override
    public String toString() {

        return name;
    }

    public void update(java.util.Observable tablet, Object arg) {  //arg - само значение, в нашем случае - это объект Order

        Order order = (Order) arg;


        writeMessage("Start cooking - " + arg.toString() + ", cooking time " + order.getTotalCookingTime() + "min");

        setChanged();
        notifyObservers(arg);

    }


    public void notifyObservers(Order order) {


    }


}
