package com.javarush.task.task13.task1326;

/*
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String nameFile=bufferedReader.readLine();
        bufferedReader.close();

        InputStream inputStream=new FileInputStream(nameFile);
        Scanner scanner=new Scanner(inputStream);

        List<Integer> array2=new ArrayList<>();

        while (scanner.hasNextLine()) {
            int line=Integer.parseInt(scanner.nextLine());
            if (line % 2 == 0 && line != 0) {
                array2.add(line);
            }

        }
        Collections.sort(array2);


        inputStream.close();
        for (Integer numberless : array2
                ) {
            System.out.println(numberless);

        }


    }

}

