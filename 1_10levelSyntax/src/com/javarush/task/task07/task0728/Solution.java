package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int[] array=new int[20];
        for (int i=0; i < 20; i++) {
            array[i]=Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        for (int i=0; i < array.length - 1; i++) {
            int max1=array[i];
            int count=i;


            for (int j=i + 1; j < array.length; j++) {

                if (array[j] > max1) {//задача найти самое большое или маленькое значение в массиве
                    max1=array[j];

                    count=j;   //запомнить индекс  на котором нашел это значение

                }
            }
//count++;

            if (count != i) {  // если превыдущее условие выполнилось хоть один раз тогда выполнить это!!
                int tmp=array[count];    //охраняешь старое значение array[count]  в tmp
                array[count]=array[i];    // присваеваешь array[count] значение array[i]
                array[i]=tmp;   //присваеваешь array[i] старое значение, сохраненное в тмп
            }
        }
    }
}
