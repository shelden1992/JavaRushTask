package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {

        return new ArrayList<>(Arrays.asList(elements));
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }

    public static <K, V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {


        HashMap<K, V> hashMap=new HashMap<K, V>();
        Iterator<? extends K> i1=keys.iterator();
        Iterator<? extends V> i2=values.iterator();
        while (i1.hasNext() && i2.hasNext()) {
            hashMap.put(i1.next(), i2.next());
        }
        if (i1.hasNext() || i2.hasNext())
            throw new IllegalArgumentException();

        return hashMap;

    }


}

//    Методы newArrayList, newHashSet параметризируй типом T.
//    Метод newHashMap параметризируй типами К(ключ) и V(значение). Аргументы метода newHashMap должны принимать списки, в которых содержатся наследники типов K и V.
//    Возвращаемые коллекции должны быть такого же типа, что и переданные в метод объекты.
//
//    Подсказка: в методе newHashMap нужно проверить чтобы списки ключей и значений совпадали по размерам, в противном случае кинь IllegalArgumentException.



