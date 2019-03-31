package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

import static com.javarush.task.task37.task3707.HashMapReflectionHelper.*;

public class AmigoSet<E> extends AbstractSet<E> implements Cloneable, Serializable, Set<E> {
    private static final Object PRESENT=new Object();
    private transient HashMap map;


    public AmigoSet(Collection<? extends E> collection) {
        map=new HashMap<>(Math.max((int) ( collection.size() / .75f ) + 1, 16));

//        В объект map должны быть добавлены все элементы коллекции переданной в конструктор с одним параметром типа Collection.

        this.addAll(collection);

//        for (E e: collection
//             ) {
//            map.put(e, PRESENT);
//
//        }
    }

    public AmigoSet() {

        map=new HashMap<>();

    }
//    добавь в map элемент 'e' в качестве ключа и PRESENT в качестве значения.
//
//    Верни true, если был добавлен новый элемент, иначе верни false.


    public boolean add(E e) {

        return null == map.put(e, PRESENT);


    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public Iterator iterator() {

        return map.keySet().iterator();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public boolean remove(Object o) {

        return null == map.remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    //    Он возвращает экземпляр объекта с копированными полями-примитивами и ссылками.
    @Override
    public Object clone() {
        try {


            AmigoSet<E> amigoSetCopy=(AmigoSet<E>) super.clone();
            amigoSetCopy.map=(HashMap) map.clone();

            return amigoSetCopy;
        } catch (Exception e) {
            throw new InternalError(e);
        }

    }

    public static void main(String[] args) {

    }

    private void writeObject(ObjectOutputStream obj) {


//        AmigoSet <E> amigoSet = new AmigoSet<>();
        try {
//            obj = new ObjectOutputStream( );
            obj.defaultWriteObject();
            obj.writeObject(map.size());
            obj.writeObject(callHiddenMethod(map, "capacity"));
            obj.writeObject(callHiddenMethod(map, "loadFactor"));
            for (Object k : map.keySet()
            ) {
                obj.writeObject(k);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }//сначала нужно сериализовать обьект
//     сериализуй сет
//* сериализуй capacity и loadFactor у объекта map, они понадобятся для десериализации.
//Т.к. эти данные ограничены пакетом, то воспользуйся утилитным классом HashMapReflectionHelper, чтобы достать их.

    private void readObject(ObjectInputStream obj) {
        try {
            obj.defaultReadObject();
            int size=(int) obj.readObject();
            int capacity=(int) obj.readObject();
            float loadFactor=(float) obj.readObject();
            map=new HashMap(capacity, loadFactor);
            while (obj.available() >= 0) {
                map.put(obj.readObject(), PRESENT);

            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AmigoSet<?> amigoSet=(AmigoSet<?>) o;
        return Objects.equals(map, amigoSet.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), map);
    }
}
