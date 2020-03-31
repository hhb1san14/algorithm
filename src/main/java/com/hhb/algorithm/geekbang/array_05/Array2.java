package com.hhb.algorithm.geekbang.array_05;

/**
 * @author: huanghongbo
 * @Date: 2020-03-30 15:47
 * @Description: 实现一个大小固定的有序数组，支持动态增删改操作
 */
public class Array2<T> {


    private int size;

    private T[] array;

    public Array2() {
        this(10);
    }

    public Array2(int size) {
        array = (T[]) new Object[size];
        size = 0;
    }

    public T get(int index) {
        return array[index];
    }


    public void add(int index, T t) {
        checkIndex(index);
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = t;
        size++;
    }

    public void update(int index, T t) {
        checkIndex(index);
        array[index] = t;
    }

    public T remove(int index) {
        checkIndex(index);
        T t = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return t;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException("Add failed");
        }
    }

    public static void main(String[] args) {

        Array2<Integer> array = new Array2<>(2);
        array.add(0, 1);
        array.add(1, 2);
        for (int i = 0; i < array.size; i++) {
            System.err.println(array.get(i));
        }
        System.err.println(array.remove(0));
        System.err.println("===========");
        for (int i = 0; i < array.size; i++) {
            System.err.println(array.get(i));
        }
    }


}
