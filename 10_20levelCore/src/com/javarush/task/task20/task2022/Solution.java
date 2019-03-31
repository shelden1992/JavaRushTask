package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private String fileName;
    private transient FileOutputStream stream;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {


        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

        in.defaultReadObject();
        this.stream =new FileOutputStream(this.fileName, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution sol = new Solution("2 write object");
        sol.writeObject("2 write object");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object"));
        oos.writeObject(sol);
        oos.flush();
        oos.close();

        ObjectInputStream oIS = new ObjectInputStream(new FileInputStream("object"));
        Solution loadedSol = (Solution)oIS.readObject();
        loadedSol.writeObject("5 write object");
        System.out.println(sol.fileName + " " +  loadedSol.fileName);

    }
}
