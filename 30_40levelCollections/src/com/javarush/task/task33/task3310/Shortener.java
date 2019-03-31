package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
    private Long lastId=0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {

        this.storageStrategy=storageStrategy;
    }

    public synchronized Long getId(String string) {
        if (storageStrategy.containsValue(string)) {
            return storageStrategy.getKey(string);
        } else {
            lastId++;
            storageStrategy.put(lastId, string);
            return lastId;
        }


    }

    public String getString(Long id) {
        return storageStrategy.getValue(id);

//        Реализуй метод getString, он должен вернуть строку по заданному идентификатору (ключу).
//        3.6. Предусмотреть возможность вызова методов getId и getString из разных потоков добавив соответствующий модификатор к заголовкам методов.

    }
}
