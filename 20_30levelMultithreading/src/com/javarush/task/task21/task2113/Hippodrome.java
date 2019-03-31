package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses=horses;
    }

    public static void main(String[] args) {

        List<Horse> listHorse=new ArrayList<>();
        listHorse.add(new Horse("Зефир", 3, 0));
        listHorse.add(new Horse("Сивый", 3, 0));
        listHorse.add(new Horse("Лапка", 3, 0));
        game=new Hippodrome(listHorse);
        game.run();
        game.printWinner();
    }

    public void run() {
        for (int i=0; i < 100; i++) {
            try {
                Thread.sleep(200);
                move();
                print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : getHorses()) {
            horse.print();
        }

        for (int i=0; i < 10; i++) {
            System.out.println("");
        }

    }

    public Horse getWinner() {

        Horse winner=new Horse(null, 0, 0);
        int horseNumb=0;
        double maxDistance=0;

        for (int i=0; i < getHorses().size(); i++) {

            if (this.horses.get(i).getDistance() > maxDistance) {
                maxDistance=this.horses.get(i).getDistance();
                horseNumb=i;
            }
        }
        winner=this.horses.get(horseNumb);
        return winner;


    }

    public void printWinner() {
        Horse winner=getWinner();

        System.out.println("Winner is " + winner.getName() + "!");
    }

}
