package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name=new File("/Users/macuser/OneDrive/JavaRushTasks/JavaRushTasks/text.txt");  //"D:/JavaRushTasks/2.JavaCore/src/1.txt"
            OutputStream outputStream=new FileOutputStream(your_file_name);
            InputStream inputStream=new FileInputStream(your_file_name);

            JavaRush javaRush=new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1=new User();
            user1.setFirstName("Pete");
            user1.setLastName("Ivanov");

            user1.setBirthDate(new Date(123133L));
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);


            javaRush.users.add(user1);


            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject=new JavaRush();
            if (loadedObject == javaRush) {
                loadedObject.load(inputStream);
            }

            System.out.println(javaRush.equals(loadedObject) ? "TRUE" : "FALSE");

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users=new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            try (PrintWriter pw=new PrintWriter(outputStream)) {

                if (users != null) {

                    for (int i=0; i < users.size(); i++) {
                        pw.println(users.get(i).getFirstName());
                        pw.println(users.get(i).getLastName());

                        pw.println(users.get(i).getBirthDate().getTime());


                        pw.println(users.get(i).isMale());
                        pw.println(users.get(i).getCountry());
                    }

                }

            }

        }

        public void load(InputStream inputStream) throws Exception {

            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                String name=reader.readLine();
                String sorname=reader.readLine();

                long fd=Long.parseLong(reader.readLine());
                Date date=new Date(fd);

                boolean sex=Boolean.parseBoolean(reader.readLine());
                User.Country country=User.Country.valueOf(reader.readLine());

                User user=new User();

                user.setFirstName(name);
                user.setLastName(sorname);

                user.setBirthDate(date);

                user.setMale(sex);
                user.setCountry(country);

                this.users.add(user);

            }


        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush=(JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
//    D:\JavaRushTasks\2.JavaCore\src\1.txt