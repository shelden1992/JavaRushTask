package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws NoSuchMethodException, IllegalAccessException, InstantiationException {


        Class[] classes=Collections.class.getDeclaredClasses();


        for (Class c : classes
        ) {

            if (Modifier.isStatic(c.getModifiers()) && Modifier.isPrivate(c.getModifiers())) {

//
                if (List.class.isAssignableFrom(c)) {
                    try {
                        Constructor constructor=c.getDeclaredConstructor();
                        constructor.setAccessible(true);
                        List list=(List) constructor.newInstance();
                        list.get(0);
                    } catch (IndexOutOfBoundsException e) {
                        // вернуть класс
                        return c;
                    } catch (NoSuchMethodException e) {
                        //e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        //e.printStackTrace();
                    }
                }

            }
        }
        return null;
    }
}
