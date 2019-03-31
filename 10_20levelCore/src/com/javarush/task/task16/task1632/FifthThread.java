package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FifthThread extends Thread {
    @Override
    public void run() {
        Scanner scanner=new Scanner(System.in);
        String s=" ";
        List<Integer> list=new ArrayList<>();

        while (!( s=scanner.next() ).equals("N")) {


            try {

                list.add(Integer.parseInt(s));


            } catch (NumberFormatException e) {
                countOfEnterNumbers(list);

            }
        }

        countOfEnterNumbers(list);


    }

    private void countOfEnterNumbers(List<Integer> list) {
        int z=0;
        for (Integer ints : list
        ) {
            z+=ints;
        }
        System.out.println(z);

    }
}
