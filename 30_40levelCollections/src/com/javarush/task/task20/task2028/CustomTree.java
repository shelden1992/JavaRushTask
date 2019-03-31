package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    private int size;


    public CustomTree() {
        this.root=new Entry<>("0");
    }


    @Override
    public boolean add(String elementName) {
        Entry<String> top=root;
        Entry<String> current=new Entry(elementName);
        Queue<Entry> queue=new LinkedList<>();
        do {
            if (top.leftChild != null) {//Если в левом поддереве есть нода - добавить её в очередь
                queue.add(top.leftChild);
            } else {
                top.leftChild=current;//Создаем новую ноду в левом поддереве в случаи, если ноды нет
                top.leftChild.parent=top;//Указываем родителя
                size++;
                return true;
            }
            if (top.rightChild != null) {//Если в правом поддереве есть нода - добавить её в очередь
                queue.add(top.rightChild);
            } else {
                top.rightChild=current;//Создаем новую ноду в правом поддереве
                top.rightChild.parent=top;//Указывае родителя
                size++;
                return true;
            }
            if (!queue.isEmpty()) {
                top=queue.poll();//Берём из начала очереди и устанавливаем, как top
            }
        } while (!queue.isEmpty());
        queue.clear();
        return false;
    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }


    public String set(int index, String element) {
        throw new UnsupportedOperationException();

    }

    public void add(int index, String element) {
        throw new UnsupportedOperationException();

    }

    public String remove(int index) {
        throw new UnsupportedOperationException();

    }

    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();

    }

    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();

    }

    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();

    }

    public String getParent(String s) {
        Entry top=root;
        String result="no element";
        Queue<Entry> queue=new LinkedList<>();
        queue.add(top);
        do {
            if (top.elementName != null) {
                if (top.elementName.equals(s)) {
                    result=top.parent.elementName;
                    break;
                }
            }
            if (top.leftChild != null) queue.add(top.leftChild);
            if (top.rightChild != null) queue.add(top.rightChild);
            if (!queue.isEmpty()) top=queue.poll();
        } while (!queue.isEmpty());
        return result;
    }

    static class Entry<T> implements Serializable {   // мой нод <со значением>
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;  //он может быть как левым так и правым

        Entry<T> parent, leftChild, rightChild;


        public Entry(String elementName) {
            this.elementName=elementName;
            this.availableToAddLeftChildren=true;
            this.availableToAddRightChildren=true;


        }

        public void checkChildren() {
            if (leftChild != null) {
                this.availableToAddLeftChildren=false;
            }

            if (rightChild != null) {
                this.availableToAddRightChildren=false;
            }


        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean remove(Object o) {
        String str=null;
        try {
            str=(String) o;
        } catch (ClassCastException e) {
            throw new UnsupportedOperationException();
        }

        if (this.contains(o)) {
            Entry<String> top=root;
            Entry<String> search=null;

            Queue<Entry> queue=new LinkedList<>();
            queue.add(top);
            do {
                if (!queue.isEmpty()) top=queue.poll();
                if (top.elementName != null) {
                    if (top.elementName.equals(str)) {
                        search=top;
                        break;
                    }
                }
                if (top.leftChild != null) queue.add(top.leftChild);
                if (top.rightChild != null) queue.add(top.rightChild);
            } while (!queue.isEmpty());
            queue.clear();
            top=search;
            search=top.parent;
            if (search != null && search.leftChild == top) {
                search.leftChild=null;
            } else if (search != null && search.rightChild == top) {
                search.rightChild=null;
            }
            queue.add(top);
            do {
                top=queue.poll();
                if (top.leftChild != null) queue.add(top.leftChild);
                if (top.rightChild != null) queue.add(top.rightChild);
                top=null;
                size--;
            } while (!queue.isEmpty());
            queue.clear();
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Entry<String> top=root;
        boolean result=false;
        Queue<Entry> queue=new LinkedList<>();
        queue.add(top);
        do {
            top=queue.poll();
            if (top.elementName != null) {
                if (top.elementName.equals(o)) {
                    result=true;
                    break;
                }
            }
            if (top.leftChild != null) queue.add(top.leftChild);
            if (top.rightChild != null) queue.add(top.rightChild);

        } while (!queue.isEmpty());
        return result;
    }
}
