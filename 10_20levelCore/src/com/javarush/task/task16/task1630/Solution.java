package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {

    public static String firstFileName;
    public static String secondFileName;

    static {
        try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName=bufferedReader.readLine();
            secondFileName=bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f=new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fullFileName;
        private StringBuilder stringBuilder=new StringBuilder();

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName=fullFileName;


        }

        @Override
        public String getFileContent() {
            if (stringBuilder == null) {
                return "";
            }
            return stringBuilder.toString();


        }
//
//        @Override
//        public void join() throws InterruptedException {
//
//        }


        @Override
        public void run() {
            try (BufferedReader bufferedReader=new BufferedReader(new FileReader(fullFileName))) {
                String s=" ";
                while (( s=bufferedReader.readLine() ) != null) {
                    stringBuilder.append(s).append(" ");
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    //add your code here - добавьте код тут
}
