package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Objects;

public class Entry implements Serializable {
    Long key;
    String value;
    Entry next;
    int hash;

    public Long getKey() {

        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public Entry(int hash,Long key, String value, Entry next) {
        this.key=key;
        this.value=value;
        this.next=next;
        this.hash=hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry=(Entry) o;
        return key.equals(entry.key) &&
                Objects.equals(value, entry.value);
    }

    public void setKey(Long key) {
        this.key=key;
    }

    public void setValue(String value) {
        this.value=value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        final StringBuilder sb=new StringBuilder( );
        sb.append(key).append("=");
        sb.append(value) ;
        return sb.toString();
//        ey + "=" + value
    }

}
