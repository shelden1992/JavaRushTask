package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


//этот класс не хранит никаких данных и состояний, поэтому все методы будут статическими.
public class ConsoleHelper {

    static BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String s="";
        s=bufferedReader.readLine();


        return s;

    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> orderDish=new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        EnumSet<Dish> allDishes=EnumSet.allOf(Dish.class);

        writeMessage("Please choose you dish");
        String chooseDish=null;
        String exit="exit";


        while (!( chooseDish=readString() ).equalsIgnoreCase(exit)) {


            try {


                orderDish.add(Dish.valueOf(chooseDish));
            } catch (IllegalArgumentException e) {
                writeMessage("This dish not introduce in our restore");
            }

        }





        return orderDish;


}
}
