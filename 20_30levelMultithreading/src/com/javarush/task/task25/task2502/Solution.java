package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            String[] str =  loadWheelNamesFromDB();
            if(str.length!=4 || str == null  ) throw new IllegalArgumentException();
                    wheels = new LinkedList<>();
            for (int i=0; i<str.length; i++){

                wheels.add( Wheel.valueOf(str [i]));
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
//        for (Enum<Wheel> wh: Wheel.values()
//             ) {
//            System.out.println(wh);
//        }

    }
}
