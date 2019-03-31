package com.javarush.task.task18.task1812;

import java.io.*;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    BufferedReader in =new BufferedReader( new InputStreamReader(System.in));
private AmigoOutputStream amigoOutputStream;

    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream) {
        this.amigoOutputStream=amigoOutputStream;
    }

    @Override
    public void flush() throws IOException {
        amigoOutputStream.flush();

    }

    @Override
    public void write(int b) throws IOException {
amigoOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        amigoOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        amigoOutputStream.write(b,off,len);
    }

    @Override
    public void close() throws IOException {

        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String st = in.readLine();
        if (st.equals("Д")){
            amigoOutputStream.close();
        }
        else return;



    }

}


