package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;  //начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private int hits;           //количество оплаченных показов
    private int duration;       // продолжительность в секундах
    private long amountPerOneDisplaying;
//    private long costOneSecond;

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }


    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content=content;
        this.name=name;
        this.initialAmount=initialAmount;
        this.hits=hits;
        this.duration=duration;


        this.amountPerOneDisplaying=hits > 0 ? initialAmount / hits : 0;


    }

    public void revalidate() {
        hits--;
        if (hits <= 0) throw new UnsupportedOperationException();

    }


    public int getHits() {
        return this.hits;


    }
}
