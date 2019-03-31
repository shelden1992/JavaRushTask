package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;
    private int MAX_TRUCK_SPEED  ;
    private int MAX_SEDAN_SPEED;
    private int MAX_CABRIOLET_SPEED;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
//        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0){

                throw new Exception();

        }
        fuel += numberOfLiters;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        if (date.before(summerStart) || date.after(summerEnd)) {
            return false;
        }
        else return true;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {

        if (!isSummer(date, SummerStart, SummerEnd)) {
            return getWinterConsumption(length);

        } else {
            return getSummerConsumption(length);

        }
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred())
            return numberOfPassengers;
        else
        return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
           fastenDriverBelt();

        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract  int getMaxSpeed();

    public static Car create(int type, int numberOfPassengers) {
        Car car = null;
        if (type == TRUCK) {
            car = new Truck(numberOfPassengers);
        } else if (type == SEDAN) {
            car = new Sedan(numberOfPassengers);
        } else if (type == CABRIOLET) {
            car = new Cabriolet(numberOfPassengers);

        }
        return car;
    }

    public double getWinterConsumption(int length) {
        double consumption;
        consumption = length * winterFuelConsumption + winterWarmingUp;
        return consumption;


    }

    public double getSummerConsumption(int length) {
        double consumption;
        consumption = length * summerFuelConsumption;
        return consumption;

    }
    private boolean canPassengersBeTransferred(){
        if (isDriverAvailable() && fuel>0) {
            return true;}

            else return false;
    }

}