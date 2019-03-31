package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString=bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        char[] charWithRomNumber=s.toCharArray();
        int year=0;
        for (int i=0; i < charWithRomNumber.length; i++) {
            switch (charWithRomNumber[i]) {
                case ( 'I' ):
                    if (i + 1 < charWithRomNumber.length && charWithRomNumber[i + 1] == 'X') {
                        year+=9;
                        i++;
                        break;
                    } else if (i + 1 < charWithRomNumber.length && charWithRomNumber[i + 1] == 'V') {
                        year+=4;
                        i++;
                        break;
                    }
                    year+=1;
                    break;
                case ( 'V' ):
                    year+=5;
                    break;

                case ( 'X' ):
                    if (i + 1 < charWithRomNumber.length && charWithRomNumber[i + 1] == 'L') {
                        year+=40;
                        i++;
                        break;
                    } else if (i + 1 < charWithRomNumber.length && charWithRomNumber[i + 1] == 'C') {
                        year+=90;
                        i++;
                        break;
                    }

                    year+=10;
                    break;
                case ( 'L' ):

                    year+=50;
                    break;
                case ( 'C' ):

                    if (i + 1 < charWithRomNumber.length && charWithRomNumber[i + 1] == 'D') {
                        year+=400;
                        i++;
                        break;
                    } else if (i + 1 < charWithRomNumber.length && charWithRomNumber[i + 1] == 'M') {
                        year+=900;
                        i++;
                        break;
                    }


                    year+=100;
                    break;
                case ( 'D' ):
                    year+=500;
                    break;
                case ( 'M' ):
                    year+=1000;
                    break;

            }

        }
        return year;
    }
}
