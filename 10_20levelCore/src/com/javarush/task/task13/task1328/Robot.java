package com.javarush.task.task13.task1328;

public class Robot extends AbstractRobot {
    private static int hitCount;
    private String name;

    public static int getHitCount() {
        return hitCount;
    }

    public static void setHitCount(int hitCount) {
        Robot.hitCount=hitCount;
    }

    public void setName(String name) {
        this.name=name;
    }

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
