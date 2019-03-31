package com.javarush.task.task34.task3409;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Настраиваем логгер
*/
public class Solution {
    public static void main(String args[]) throws IOException {
        String logProperties = "4.JavaCollections/src/" + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/log4j.properties";
        Path path = Paths.get(logProperties).toAbsolutePath();
        Properties properties;
        try (InputStream is = new FileInputStream(path.toFile())) {
            properties   = new Properties();
            properties.load(is);
        }

//    /Users/macuser/Documents/JavaRushTasks/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task34/task3409/log4j.properties
    }
}
