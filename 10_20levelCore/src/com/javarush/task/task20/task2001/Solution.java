package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("/Users/macuser/OneDrive/JavaRushTasks/JavaRushTasks/text.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));

            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();


            System.out.println( ivanov.equals(somePerson)?"True":"False");
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        String isAssetsPresent = assets.size() != 0 ? "yes" : "no";

        public void save(OutputStream outputStream) throws Exception {
          try (PrintWriter printWriter = new PrintWriter(outputStream)){

//              printWriter.println(isAssetsPresent);
              printWriter.flush();
              if (name!=null){
                printWriter.println(name);
              }


              for (Asset as: assets
                   ) {
                  printWriter.println(as.getName());
                  printWriter.println(as.getPrice());

              }
          }



        }

        public void load(InputStream inputStream) throws Exception {
            try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream))) {
                if (name!=null){

                  name =  bufferedReader.readLine();

                }
//                List<Asset> list = new ArrayList<Asset>();

                if (isAssetsPresent.equals("yes")) {
                    while (bufferedReader.ready()) {
                        assets.add(new Asset(bufferedReader.readLine(),  Double.parseDouble(bufferedReader.readLine())));
                    }
                }



                }
            }
        }
    }
