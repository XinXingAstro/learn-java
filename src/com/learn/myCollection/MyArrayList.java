package com.learn.myCollection;

import java.util.ArrayList;

/**
 * 模拟实现JDK中的ArrayList容器
 */
public class MyArrayList {
    /**
     * The value is used for Object storage.
     */
    private Object[] value;

    /**
     * The size is the number of objects used.
     */
    private int size;

    public int getSize() {
        return size;
    }

    public MyArrayList() {
        //value = new Object[16];
        this(16); //在这个构造器里调用另一个构造器: MyArrayList(int size)
    }

    public MyArrayList(int size) {
        value = new Object[size];
    }


    public void add(Object obj) {
        value[size] = obj;
        size++;
        if(size >= value.length) {
            int newCapacity = value.length << 1;
            Object[] newList = new Object[newCapacity];
            for(int i = 0; i < value.length; i++) {
                newList[i] = value[i];
            }
            value = newList;
        }
    }

    public Object get(int index) {
        if(index < 0 || index > size-1) {
            try {
                throw new Exception();  //手动抛出异常
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value[index];
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(2);
        list.add("aaa");
        list.add(new Human("xinxing"));
        list.add("bbb");

        Human h = (Human)list.get(1);
        System.out.println(h.getName());

        ArrayList l;
    }
}
