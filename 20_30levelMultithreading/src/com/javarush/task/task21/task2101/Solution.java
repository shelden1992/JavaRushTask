package com.javarush.task.task21.task2101;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip=new byte[]{(byte) 192, (byte) 168, 1, 2}; // length =4
        byte[] mask=new byte[]{(byte) 255, (byte) 255, (byte) 254, 0}; //length =4 !!!255= -1!!! 254= -2!!!!
        byte[] netAddress=getNetAddress(ip, mask);      //(записываем 2 массива в один после поразрядной коньюгации)
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {


        byte[] netAddres=new byte[4];
        for (int i=0; i < ip.length; i++) {
            netAddres[i]=(byte) ( ip[i] & mask[i] );


        }
        return netAddres;

    }

    public static void print(byte[] bytes) {
        for (int i=0; i < bytes.length; i++) {
            System.out.print(Integer.toBinaryString(bytes[i] & 255 | 256).substring(1) + " ");
        }
        System.out.println();

        //
        //toBinaryString - выводит двоичное представление числа
        //b & 0xFF - побитовая операция "И", 0xFF = 11111111 (256)
        //для положительных b эта операция ничего не сделает, 1&1 = 1 1&0 = 0
        //но для отрицательных чисел двоичное представление -1 -> 11111111111111111111111111111111
        //тут операция & 0xFF обрежет число по длине до 8 правых байт
        //
        //+ 0x100 - добавит 1000000 (т.е. к нашему обрезанному 8-битовому числу будет добавлен старший бит 1).
        //substring(1) - отрежет добавленный первый бит
        //выглядит как бред, но если этого не делать, то 3 будет 11, а если делать + 0x100 и substring(1),
        // получится 00000011, таким образом числа получат "красивое" представление с одинаковой длиной 8 бит.
    }
}
