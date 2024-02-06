package com.example.coding.algorithm.demo;

/**
 * @author liutc
 * @date 2023/12/26 16:48
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = {1, 4, 3, 5, 8, 4, 3};
        selectSort(a);

        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void selectSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
                int tem = array[minIndex];
                array[minIndex] = array[i];
                array[i] = tem;
            }
        }
    }
}
