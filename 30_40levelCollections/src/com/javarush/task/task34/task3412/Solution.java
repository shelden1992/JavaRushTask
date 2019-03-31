//package com.javarush.task.task34.task3412;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Date;
//import java.util.Properties;
//import java.util.logging.ConsoleHandler;
//import java.util.logging.Handler;
//
///*
//Добавление логирования в класс
//*/
//
//public class Solution {
//    private static final Logger logger = LoggerFactory.getLogger(Solution.class.getName());
//
//    private static Properties properties;
//static {
//    String logProperties = "4.JavaCollections/src/" + com.javarush.task.task34.task3409.Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/log4j.properties";
//    Path path = Paths.get(logProperties).toAbsolutePath();
//
//    try (InputStream is = new FileInputStream(path.toFile())) {
//        properties   = new Properties();
//        properties.load(is);
//    } catch (FileNotFoundException e) {
//        e.printStackTrace();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
//    private int value1;
//    private String value2;
//    private Date value3;
//
//    public Solution(int value1, String value2, Date value3) {
//        logger.debug("value1 in constructor",value1);
////        logger.debug("value2 in constructor",value2);
////        logger.debug("value3 in constructor",value3);
//        this.value1 = value1;
//        this.value2 = value2;
//        this.value3 = value3;
////        используй при изменениях значений полей класса
//
//    }
//
//    public static void main(String[] args) {
//        Handler console = new ConsoleHandler();
//        logger.
//        Solution s =  new Solution(1, "2", new Date(2011, 11,11));
//    s.calculateAndSetValue3(1);
//    s.divide(12,2);
//    s.printString();
//    s.printDateAsLong();
//    s.setValue1(1);
//    s.setValue2("3");
//    s.setValue3(new Date());
//
//
//    }
//
//    public void calculateAndSetValue3(long value) {
//        logger.trace("enter to method");
//        value -= 133;
//        if (value > Integer.MAX_VALUE) {
//            value1 = (int) (value / Integer.MAX_VALUE);
//            logger.debug("value1 change");
//
//        } else {
//            value1 = (int) value;
//            logger.debug("value1 change");
//        }
//    }
//
//    public void printString() {
//        logger.trace("enter to method");
//        if (value2 != null) {
//            System.out.println(value2.length());
//        }
//    }
//
//    public void printDateAsLong() {
//        logger.trace("enter to method");
//        if (value3 != null) {
//            System.out.println(value3.getTime());
//        }
//    }
//
//    public void divide(int number1, int number2) {
//        logger.trace("enter to method");
//        try {
//
//            System.out.println(number1 / number2);
//        } catch (ArithmeticException e) {
//            logger.error("ArithmeticException ", e);
//        }
//    }
//
//    public void setValue1(int value1) {
//
//        this.value1 = value1;
//        logger.debug("change value1");
//    }
//
//    public void setValue2(String value2) {
//
//        this.value2 = value2;
//        logger.debug("change value2");
//    }
//
//    public void setValue3(Date value3) {
//
//        this.value3 = value3;
//        logger.debug("change value3");
//    }
//}
