package com.javarush.task.task18.task1814;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
private FileInputStream fileInputStream;

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(String.valueOf(fileName));
        if (!fileName.toString().endsWith(".txt")){
            super.close();
            throw new UnsupportedFileNameException();
        }


    }

    public static void main(String[] args) throws UnsupportedFileNameException {
        try {
            TxtInputStream txtInputStream = new TxtInputStream( "/Users/macuser/Desktop/Directory22/Text.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

