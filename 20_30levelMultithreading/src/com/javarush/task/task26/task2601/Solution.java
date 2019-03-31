package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[]array ={13, 8, 15, 5, 17,1};
//// 1 5 8 13 15 17  //21/2 =10,5
//        System.out.println(Arrays.toString(sort(array)));

    }

    public static Integer[] sort(Integer[] array) {
        double medium;
        Arrays.sort(array);
        if (array.length%2==0){
             medium= (array [ (array.length/2)]+  array [(array.length/2)- 1])/2;
        }
        else {
              medium =array[(array.length/2)];}

        final double finalMedium = medium;
        Arrays.sort(array, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                int result = (int) (Math.abs(o1 - finalMedium) - Math.abs(o2 - finalMedium));
                return result == 0 ? o1 - o2 : result;
            }
        });




        return array;
    }
}
