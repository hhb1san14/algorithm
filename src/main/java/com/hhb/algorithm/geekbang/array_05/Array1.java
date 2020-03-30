package com.hhb.algorithm.geekbang.array_05;


/**
 * @author: huanghongbo
 * @Date: 2020-03-30 14:26
 * @Description: 实现一个支持动态扩容的数组
 */
public class Array1<T> {

    private int size;

    private T[] array;

    /**
     * 无参数的构造方法，默认数组初始容量为10
     */
    public Array1() {
        this(10);
    }

    /**
     * 初始化数组容量
     *
     * @param size 数组容量
     */
    public Array1(int size) {
        this.size = 0;
        array = (T[]) new Object[size];
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int size() {
        return array.length;
    }

    /**
     * 获取数组里元素的数量
     *
     * @return
     */
    public int getCapacity() {
        return size;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 修改某个元素的值
     *
     * @param index
     * @param t
     */
    public void set(int index, T t) {
        checkIndex(index);
        array[index] = t;
    }

    /**
     * 获取某个位置的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    /**
     * 判断数组是否包含某个元素
     *
     * @param t
     * @return
     */
    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (t.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 寻找某个元素的下标
     *
     * @param t
     * @return
     */
    public int find(T t) {
        for (int i = 0; i < size; i++) {
            if (t.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 在指定位置插入数据
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        if (size == array.length) {
            resize(2 * array.length);
        }

        for (int i = size - 1; i > index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = e;
        size++;
    }

    /**
     * 向数组头插入元素
     *
     * @param e
     */
    public void addFirst(T e) {
        this.add(0, e);
    }

    /**
     * 向数组尾插入元素
     *
     * @param e
     */
    public void addEnd(T e) {
        this.add(size, e);
    }

    /**
     * 删除 index 位置的元素，并返回
     */
    public T remove(int index) {
        checkIndex(index);
        T e = array[index];
        for (int i = index + 1; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array[size] = null;
        // 缩容
        if (size == array.length / 4 && array.length / 2 != 0) {
            resize(array.length / 2);
        }
        return e;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public T removeEnd() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除指定元素
     *
     * @param e
     */
    public void removeElement(T e) {
        int i = find(e);
        if (i != -1) {
            remove(i);
        }
    }

    /**
     * 扩容
     *
     * @param capacity
     */
    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add Failed");
        }
    }


    public static void main(String[] args) {
        Array1<Integer> array = new Array1<>();
    }
}
