package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    private FileOutputStream fileOutputStream;

    public static String fileName="/Users/macuser/Desktop/Directory22/Text.txt" ;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);

        this.fileOutputStream=fileOutputStream;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }

    public void close() throws IOException {
        fileOutputStream.flush();
        String s="JavaRush © All rights reserved.";
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();
    }



}

