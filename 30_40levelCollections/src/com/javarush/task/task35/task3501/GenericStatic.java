package com.javarush.task.task35.task3501;

public class GenericStatic   {
    public static void main(String[] args) {
//         List<? > ins1 = new ArrayList<Integer>();
//         List<? extends Number > ins2 = new ArrayList<Integer>();
//         ins1 = new ArrayList<String>();
//
//        ins1.add(new Integer(1));
//        ins1.add(new String("1"));
//        ins2.add(new Integer(2));

    }



    public   <T>  T someStaticMethod ( T  genericObject ) {
        System.out.println(genericObject);
        return   genericObject ;
    }
}
