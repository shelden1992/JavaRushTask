package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {


    public static List<String> getFileTree(String root) throws IOException { //ссылка на root директорию (папку)
        List<String> list = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();

        File file = new File(root); //создаем файл и запихаем туда пасс, который  передали

        //и логично будет проверить является  ли  созданный файл папко / может и нет
        File[] path = file.listFiles();  // массив папок


        try {
            Collections.addAll(fileTree, path);   // добавить в очередь массив файлов

            while (!fileTree.isEmpty()) {   //пока очередь не пустая
                File currentFile = fileTree.remove(); //remove head queue
                if (currentFile.isDirectory()) {   // и если данный файл является папкой,
                    Collections.addAll(fileTree, currentFile.listFiles());  // то мы снова его добавляем в очередь и проделуем тоже
//                    самое, без рекурсии!
                } else  //аесли не папка, то добовляем в лист
                    list.add(currentFile.getAbsolutePath());
            }


        }


        catch (NullPointerException e) {
            e.printStackTrace();
        }


        return list;

    }

    public static void main(String[] args) throws IOException {
        System.out.println(getFileTree("/Users/macuser/Desktop/мама"));
    }
}
