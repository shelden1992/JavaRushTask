package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Externalizable{
    static Solution loadObject = new Solution(20);
    static Solution savedObject = new Solution(10);
    public static void main(String[] args) {



        File file = new File("/Users/macuser/OneDrive/JavaRushTasks/JavaRushTasks/text.txt");
        try(OutputStream outputStream = new FileOutputStream(file);InputStream inputStream = new FileInputStream(file)){
          try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter( outputStream));
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
              bufferedWriter.write(savedObject.temperature);
//              bufferedWriter.write(savedObject.pattern);
              bufferedWriter.write(savedObject.string);
//              bufferedWriter.write(savedObject.currentDate);
          }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(loadObject.string.equals(savedObject.string));
    }

   transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        loadObject.string = (String) in.readObject();
    }
}
