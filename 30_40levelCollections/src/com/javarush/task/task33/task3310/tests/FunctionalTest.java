package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String s1=Helper.generateRandomString();
        String s2=Helper.generateRandomString();
        String s3=s1;

        long l1=shortener.getId(s1);
        long l2=shortener.getId(s2);
        long l3=shortener.getId(s3);


        //Проверять, что идентификатор для 2 строки не равен идентификатору для 1 и 3 строк
        Assert.assertNotEquals(l2, l1);
        Assert.assertNotEquals(l2, l3);

        Assert.assertEquals(l1, l3);
// Получать три строки по трем идентификаторам с помощью shortener.
//14.4.6. Проверять, что строки, полученные в предыдущем пункте, эквивалентны оригинальным.
        String fronIndf1=shortener.getString(l1);
        String fronIndf2=shortener.getString(l2);
        String fronIndf3=shortener.getString(l3);
        Assert.assertEquals(s1, fronIndf1);
        Assert.assertEquals(s2, fronIndf2);
        Assert.assertEquals(s3, fronIndf3);
    }

    @Test
    public void testHashMapStorageStrategy() {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy()
    {
        StorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testFileStorageStrategy()
    {
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(fileStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testHashBiMapStorageStrategy()
    {
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hashBiMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy()
    {
        DualHashBidiMapStorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(dualHashBidiMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashBiMapStorageStrategy()
    {
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashBiMapStorageStrategy);
        testStorage(shortener);
    }
}
