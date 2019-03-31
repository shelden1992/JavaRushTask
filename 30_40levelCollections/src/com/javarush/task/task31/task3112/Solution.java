package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.List;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        List<String> lsit = new LinkedList<>();
        lsit.add("1");
        lsit.add("2");

        Path passwords=downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException { // urlString -  от куда //downloadDirect - куда
        URL url=new URL(urlString);
        Path tmpFile=Paths.get(Files.createTempFile("data", null).toString());
        Path destPath=null;

        try (InputStream urlStream=url.openStream()) {
            try {
                Files.copy(urlStream, tmpFile, StandardCopyOption.REPLACE_EXISTING);
                if (!Files.notExists(downloadDirectory)) {
                    String fieName=urlString.substring(urlString.lastIndexOf("/"));
                    destPath=Paths.get(downloadDirectory.toString(), fieName);
                    Files.move(tmpFile, destPath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println(fieName);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return destPath;

    }
}
