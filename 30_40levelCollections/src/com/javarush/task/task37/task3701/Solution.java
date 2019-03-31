package com.javarush.task.task37.task3701;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public static void main(String[] args) {
        Solution<Integer> list=new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count=0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    public class RoundIterator implements Iterator {
        Iterator<T> iterator=Solution.super.iterator();   //!!!!!!!!!!!!!!!!!!
        // нужно было получить итератор солутиона, а потом с ним работать

        int cursor=0;

        @Override
        public boolean hasNext() {
            if (Solution.super.size()  == 0)
                return false;

            if (cursor >= Solution.super.size()) {
                iterator=Solution.super.iterator();
                cursor=0;
            }

            return true;
        }

        @Override
        public T next() {
            cursor++;
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }

        @Override
        public void forEachRemaining(Consumer action) {
            iterator.forEachRemaining(action);
        }
    }
}


//    Перегрузи правильным образом метод iterator в классе Solution.
//        Напишите свой класс RoundIterator внутри Solution, который будет итератором для списка Solution.
//        Итератор должен ходить по кругу по всем элементам.
//        В остальном поведение должно быть идентичным текущему итератору.
