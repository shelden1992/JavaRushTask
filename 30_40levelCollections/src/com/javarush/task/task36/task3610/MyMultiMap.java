package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID=123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount=repeatCount;
        map=new HashMap<>();
    }

    @Override
    public int size() {
        int tempSize = 0;
        for (Entry<K, List<V>> maps: map.entrySet()

        ) {
            tempSize  += maps.getValue().size();

        }

        return super.size()+ tempSize;

    }

    @Override
    public V put(K key, V value) {
//        HashMap<K, V> result=new HashMap<>();
        List<V> collection=map.get(key);
        V oldValue = null;


        if (collection == null ) {
            collection=new ArrayList<>();



            collection.add(value);
//                size()++;


        }
         else {
             oldValue= collection.get(collection.size()-1);
            if (collection.size() == repeatCount)
                collection.remove(0);

             collection.add(value);


        }
        map.put(key, collection);


        return oldValue;
    }


//        ArrayListMultimap arrayListMultimap = new ArrayListMultimap<>();
//        arrayListMultimap.put();
//            return null;/

//    }
//
    @Override
    public V remove(Object key) {
        List<V> collection=map.get(key);
        V v = null;
        if (collection == null ) {
         return null;



        } else {
           v =   collection.remove(0);
           if (collection.size()==0){
               map.remove(key);
           }


        }
        return v;
    }


//
    @Override
    public Set<K> keySet() {
        Set<K> tempSet = new HashSet<>();

        for (Entry<K, List<V>> maps: map.entrySet()

        ) {
tempSet.add(maps.getKey());
        }

        return tempSet;

    }

    @Override
    public Collection<V> values() {
        ArrayList<V> arrayList = new ArrayList<>();
        for (Entry<K, List<V>> maps: map.entrySet()

        ) {
            arrayList.addAll(maps.getValue());
        }
        return arrayList;
    }

    @Override
    public boolean containsKey(Object key) {

        for (Entry<K, List<V>> maps: map.entrySet()

        )
            if (maps.getKey() == key){
                return true;}



        return false;




    }
//
    @Override
    public boolean containsValue(Object value) {
        for (Entry<K, List<V>> maps : map.entrySet()

        ) {
            for (V val : maps.getValue()) {

                if (val.equals(value)) {
                    return true;
                }
            }


        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring=sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}