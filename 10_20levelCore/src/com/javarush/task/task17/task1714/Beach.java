package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name=name;
        this.distance=distance;
        this.quality=quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name=name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance=distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality=quality;
    }

    public synchronized static void main(String[] args) {
        Beach b1=new Beach("1", 10, 10);
        Beach b2=new Beach("2", 10, 30);
        System.out.println(b1.compareTo(b2) == - b2.compareTo(b1));

    }


    @Override
    public synchronized int compareTo(Beach o) {
        if ((o.getDistance()>0 && this.getDistance()>0)){
        if (( this.getDistance() - this.getQuality() ) > ( o.getDistance() - o.getQuality() )) {
            return ( (int) ( this.getDistance() + this.getQuality() - o.getDistance() + o.getQuality() ) );
        } else if (( this.getDistance() - this.getQuality() ) < ( o.getDistance() - o.getQuality() )) {
            return ( (int) ( ( this.getDistance() - this.getQuality() ) - ( o.getDistance() - o.getQuality() ) ) );

        } else
//            (( this.getDistance() + this.getQuality() ) == ( getDistance() + getQuality()));
            return 0;}
            else return 0;

    }
}

