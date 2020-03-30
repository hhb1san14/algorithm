package com.hhb.algorithm.learn;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: huanghongbo
 * @Date: 2019-10-29 11:41
 * @Description:
 */
public class ArraySort {


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 8, 6, 4, 2, 0};
        quitSort2(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.err.print(arr[i]);
        }

    }

    private static void quitSort(int[] arr, int low, int high) {

        int start = low;
        int end = high;
        int key = arr[low];
        while (start < end) {
            while (end > start && arr[end] >= key) {
                end--;
            }
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }

            while (end > start && arr[start] <= key) {
                start++;
            }
            if (arr[start] >= key) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }

        if (start > low) {
            quitSort(arr, low, start - 1);
        }
        if (end < high) {
            quitSort(arr, end + 1, high);
        }

    }


    private static void quitSort2(int[] arr, int low, int high) {

        Map<String,String> map = new HashMap<>();
        map.put("1","1");

        int start = low;
        int end = high;
        int key = arr[low];
        while (start < end) {
            while (start < end && arr[end] >= key) {
                end--;
            }
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            while (start < end && arr[start] <= key) {
                start++;
            }
            if (arr[start] >= key) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }

        if (start > low) {
            quitSort2(arr, low, start - 1);
        }
        if (high > end) {
            quitSort2(arr, end + 1, high);
        }
    }








}
