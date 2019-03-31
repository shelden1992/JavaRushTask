package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Что внутри папки?
*/
public class Solution {
    static List<Path> listFile=new ArrayList<>();
    static List<Path> listDirect=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        long size=0;

        try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in))) {
            Path path=Paths.get(bufferedReader.readLine());

            if (Files.isDirectory(path)) {


                Files.walkFileTree(path, new MyFileVisitor());
                System.out.println("Всего файлов - " + listFile.size());
                System.out.println("Всего папок - " + (listDirect.size()-1));

                for (Path paths : listFile
                ) {
                    size+=Files.size(paths);

                }

                System.out.println("Общий размер - " + size);
            }
            else System.out.println( path +" - не папка");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                listDirect.add(dir);
                return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException { //количество файлов
           
            listFile.add(file);
            return FileVisitResult.CONTINUE;
        }
    }
}
