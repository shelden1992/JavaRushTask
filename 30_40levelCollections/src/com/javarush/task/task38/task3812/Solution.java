package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

public class Solution {
    public static void main(String[] args) throws NoSuchFieldException {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) throws NoSuchFieldException {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest prepareMyTest=(PrepareMyTest) c.getAnnotation(PrepareMyTest.class);

            for (String clas : prepareMyTest.fullyQualifiedNames()
            ) {
                System.out.println(clas);

            }


            return true;
        } else return false;

    }


    public static boolean printValues(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest prepareMyTest=(PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (Class<?> clas : prepareMyTest.value()
            ) {
                System.out.println(clas.getSimpleName());

            }

            return true;
        } else return false;

    }
}
