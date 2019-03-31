package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password=getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        byte[] bytes=new byte[8];

        while (true) {
            for (int i=0; i < 8; i++) {
                bytes[i]=(byte) ( Math.random() * 26 + 97 );


            }
            for (int i=0; i < (int) ( Math.random() * 4 ) + 1; i++) {
                bytes[i]=(byte) ( Math.random() * 26 + 65 );


            }

            for (int i=4; i < (int) ( Math.random() * 4 ) + 5; i++) {
                bytes[i]=(byte) ( Math.random() * 10 + 48 );


            }

            String parol=new String(bytes);
            if (isValid(parol)) break;
        }
        try {
            byteArrayOutputStream.write(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;


    }

    public static boolean isValid(String password) {
        Boolean atleastOneUpper=false;
        Boolean atleastOneLower=false;
        Boolean atleastOneDigit=false;

        if (password.length() < 8) { // If its less then 8 characters, its automatically not valid
            return false;
        }

        for (int i=0; i < password.length(); i++) { // Lets iterate over only once. Saving time
            if (Character.isUpperCase(password.charAt(i))) {
                atleastOneUpper=true;
            } else if (Character.isLowerCase(password.charAt(i))) {
                atleastOneLower=true;
            } else if (Character.isDigit(password.charAt(i))) {
                atleastOneDigit=true;
            }
        }

        return ( atleastOneUpper && atleastOneLower && atleastOneDigit ); // Return true IFF the password is atleast eight characters long, has atleast one upper, lower and digit
    }
}