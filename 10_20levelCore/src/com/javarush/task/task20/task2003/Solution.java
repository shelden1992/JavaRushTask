package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties=new HashMap<>();

    public void fillInPropertiesMap() throws FileNotFoundException {
        Scanner scanner=new Scanner(System.in);
        String fileName=scanner.nextLine();
       try ( FileInputStream fileInputStream=new FileInputStream(fileName)){
//            save(new FileOutputStream(fileName));
           load(fileInputStream);

       } catch (IOException e) {
           e.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       }


    }

    public void save(OutputStream outputStream) throws Exception {

        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream,"my stream");

    }

    public void load(InputStream inputStream) throws Exception {


            Properties prop = new Properties();
            prop.load(inputStream);
            properties.putAll((Map)prop);
        }


    public static void main(String[] args) {

    }
}
