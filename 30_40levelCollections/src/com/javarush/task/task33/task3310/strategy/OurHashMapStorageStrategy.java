package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy {
    private final static int DEFAULT_INITIAL_CAPACITY=16;
    private final static float DEFAULT_LOAD_FACTOR=0.75f;
    private Entry[] table=new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private int threshold=(int) ( DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR );/*Предельное количество элементов, при достижении которого, размер хэш-таблицы увеличивается вдвое. Рассчитывается по формуле*/
    private float loadFactor=DEFAULT_LOAD_FACTOR;


    @Override
    public boolean containsKey(Long key) { //!

        return getEntry(key) != null;

    }

    @Override
    public boolean containsValue(String value) { //!


        return getKey(value) != null;
    }


    @Override
    public Long getKey(String value) { //!

        for (Entry entExtend : table
        ) {
            for (Entry entInter=entExtend; entInter != null; entInter=entInter.next) {
                if (entInter.getValue().equals(value)) {
                    return entInter.getKey();
                }

            }

        }

        return null;
    }

    @Override
    public String getValue(Long key) { //!

        return null == getEntry(key) ? null : getEntry(key).getValue();


    }

    public Entry getEntry(Long key) { //!
        if (size == 0) {
            return null;
        }
        int hash=key == null ? 0 : hash(key);
        for (Entry findEntr=table[indexFor(hash, table.length)]; //нужно пройтись по всем ячейкам(нодам))
             findEntr != null;
             findEntr=findEntr.next) {

            Object k;
            if (findEntr.hash == hash && ( ( k=findEntr.getKey() ) == key || ( key != null && key.equals(k) ) )) {
                return findEntr;
            }
        }
        return null;


    }

    public int hash(Long k) {  //!

        return k.hashCode();
    }

    public int indexFor(int hash, int length) {  //!
        return hash & ( length - 1 );
    }

    public void resize(int newCapacity) {
        Entry[] oldTable=table;
        int oldCapacity=oldTable.length;
        if (oldCapacity == ( 1 << 30 )) {
            threshold=Integer.MAX_VALUE;
            return;
        }
        Entry[] newTable=new Entry[newCapacity];
        transfer(newTable);
        table=newTable;
        threshold=(int) Math.min(newCapacity * loadFactor, ( 1 << 30 ) + 1);


//        Entry [] newTable = new Entry[newCapacity];
//        System.arraycopy(table, 0, newTable, 0, table.length);


    }

    public void transfer(Entry[] newTable) {
        int newCapacity=newTable.length;
        for (Entry e : table) {
            while (null != e) {
                Entry next=e.next;
                int i=indexFor(e.hash, newCapacity);
                e.next=newTable[i];
                newTable[i]=e;
                e=next;
            }

        }
    }

    @Override
    public void put(Long key, String value) { //!
        addEntry(hash(key), key, value, indexFor(hash(key), table.length));

    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {//!

        if (( size >= threshold ) && ( null != table[bucketIndex] )) {
            resize(2 * table.length);
            hash=( null != key ) ? hash(key) : 0;
            bucketIndex=indexFor(hash, table.length);
        }
        createEntry(hash, key, value, bucketIndex);


    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) { //!
        Entry e=table[bucketIndex];

        table[bucketIndex]=new Entry(hash, key, value, e);
        size++;
    }

}
