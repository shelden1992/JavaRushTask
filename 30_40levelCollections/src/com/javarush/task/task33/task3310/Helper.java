package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {
    //Воспользуйся для этого классами SecureRandom и BigInteger
   public static String generateRandomString(){
//
//       SecureRandom secureRandom = new SecureRandom();
//       byte[] array = new byte[10];
//       secureRandom.nextBytes(array); //1 буква - 2 байта
//       return new BigInteger(1, array).toString(16); //hex encoding
 return       new BigInteger(130, new SecureRandom()).toString(36);

}
    public static void printMessage(String message){
        System.out.println(message);

    }

}
