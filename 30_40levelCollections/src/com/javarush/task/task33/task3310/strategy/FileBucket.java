package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
      
        try {

            path=Files.createTempFile("tmp" , null);
        } catch (IOException e) {
            ExceptionHandler.log(e);

        }
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);

        }
        return 0;
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream objectOutputStream=new ObjectOutputStream(Files.newOutputStream(( path )))) {

            if (entry.next == null) {
                objectOutputStream.writeObject(entry);
            } else {
                for (Entry deepEnter=entry;
                     deepEnter != null;
                     deepEnter=deepEnter.next) {
                    objectOutputStream.writeObject(deepEnter);

                }

            }
        } catch (IOException e) {
            ExceptionHandler.log(e);



        }
    }


    public Entry getEntry() {


        try {
            if (getFileSize() == 0) {
                return null;
            } else {
                try (ObjectInputStream objectInputStream=new ObjectInputStream(Files.newInputStream(path))) {

                    return (Entry) objectInputStream.readObject();


                } catch (ClassNotFoundException e) {
                    ExceptionHandler.log(e);

                }

            }
        } catch (IOException e) {
            ExceptionHandler.log(e);

        }
        return null;

    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);

        }
    }




}

