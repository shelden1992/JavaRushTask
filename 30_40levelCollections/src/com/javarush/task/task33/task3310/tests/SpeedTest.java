package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long start=System.currentTimeMillis();
        for (String st : strings
        ) {
            ids.add(shortener.getId(st));

        }
        long finish=System.currentTimeMillis();

        return finish - start;

    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long start=System.currentTimeMillis();
        for (Long localId : ids
        ) {
            strings.add(shortener.getString(localId));
        }
        long finish=System.currentTimeMillis();

        return finish - start;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1=new Shortener(new HashMapStorageStrategy());
        Shortener shortener2=new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings=new HashSet<>();
        Set<Long> origIds1= new HashSet<>();
        Set<Long> origIds2= new HashSet<>();

        for (int i=0; i < 10000; i++) origStrings.add(Helper.generateRandomString());

        Long t1=    getTimeToGetIds(shortener1, origStrings,origIds1 );
        Long t2=  getTimeToGetIds(shortener2, origStrings,origIds2 );

        Assert.assertTrue(t1>t2);


        Long t3=   getTimeToGetStrings(shortener1, origIds1, origStrings );
        Long t4=   getTimeToGetStrings(shortener2, origIds2, origStrings );

        Assert.assertEquals(t3, t4, 30);


    }

}
