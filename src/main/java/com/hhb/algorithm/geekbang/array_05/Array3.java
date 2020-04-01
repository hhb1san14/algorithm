package com.hhb.algorithm.geekbang.array_05;

/**
 * @author: huanghongbo
 * @Date: 2020-03-31 16:50
 * @Description: 实现两个有序数组合并为一个有序数组
 */
public class Array3 {


    public static void main(String[] args) {
        int[] array_1 = {1,2,4,55,66,113,157,182,192,201};
        int[] array_2 = {40,45,66,70,120,140,160,200,1655,1732};
        int[] sort = sort(array_1, array_2);
        for (int i = 0; i < sort.length; i++) {
            System.err.print(sort[i]+"  ");
        }
    }


    /**
     * 自己的实现，时间复杂度O(n)
     *
     * @param array_1
     * @param array_2
     * @return
     */
    public static int[] sort(int[] array_1, int[] array_2) {
        int array_1_length = array_1.length;
        int array_2_length = array_2.length;
        int[] array = new int[array_1_length + array_2_length];
        int array_1_index = 0, array_2_index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array_1_index == array_1_length) {
                array[i] = array_2[array_2_index];
                array_2_index++;
                continue;
            }
            if (array_2_index == array_2_length) {
                array[i] = array_1[array_1_index];
                array_1_index++;
                continue;
            }
            if (array_1[array_1_index] >= array_2[array_2_index]) {
                array[i] = array_2[array_2_index];
                array_2_index++;
            } else {
                array[i] = array_1[array_1_index];
                array_1_index++;
            }
        }
        return array;
    }

}
