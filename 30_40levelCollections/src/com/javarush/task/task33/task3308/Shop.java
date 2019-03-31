package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;
import java.util.List;



@XmlType
@XmlRootElement()
public class Shop {
    public Goods goods;
    public String[] secretData;
    public int count;
    public double profit;

    @Override
    public String toString() {
        final StringBuilder sb=new StringBuilder("Shop\n");
        sb.append(" goods\n ").append(goods).append("\n");
        sb.append("secretData").append(Arrays.toString(secretData)).append("\n");
        sb.append("count = ").append(count).append("\n");
        sb.append("profit = ").append(profit);
        return sb.toString();
    }

    @XmlType(name = "Goods")
    public static class Goods {
        @XmlAnyElement
        public List<String> names;

        @Override
        public String toString() {
            final StringBuilder sb=new StringBuilder(Arrays.toString(names.toArray()));

            return sb.toString();
        }
    }
}
