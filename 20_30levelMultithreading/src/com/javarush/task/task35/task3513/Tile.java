package com.javarush.task.task35.task3513;

import java.awt.*;

public class Tile {  // плитка
    int value;

    public Tile() {

        this.value=0;
    }

    public Tile(int value) {

        this.value=value;
    }

    public boolean isEmpty() {
        if (this.value == 0)
            return true;
        else
            return false;
    }

    public Color getFontColor() {
        Color color;
        if (this.value < 16) {
            color=new Color(0x776e65);
        } else color=new Color(0xf9f6f2);
        return color;
    }

    @Override
    public String toString() {
        final StringBuilder sb=new StringBuilder();
        sb.append(" ").append(value);
        return sb.toString();
    }

    public Color getTileColor() {
        Color color=null;


        switch (value) {
            case ( 0 ):
                color=new Color(0xcdc1b4);
                break;

            case ( 2 ):
                color=new Color(0xeee4da);
                break;
            case ( 4 ):
                color=new Color(0xede0c8);
                break;
            case ( 8 ):
                color=new Color(0xf2b179);
                break;
            case ( 16 ):
                color=new Color(0xf59563);
                break;
            case ( 32 ):
                color=new Color(0xf67c5f);
                break;
            case ( 64 ):
                color=new Color(0xf65e3b);
                break;
            case ( 128 ):
                color=new Color(0xedcf72);
                break;
            case ( 256 ):
                color=new Color(0xedcc61);
                break;
            case ( 512 ):
                color=new Color(0xedc850);
                break;
            case ( 1024 ):
                color=new Color(0xedc53f);
                break;
            case ( 2048 ):
                color=new Color(0xedc22e);
                break;

            default:
                color=new Color(0xff0000);

        }


        return color;
    }
}
