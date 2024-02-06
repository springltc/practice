package com.example.coding.algorithm;

/**
 * @author liutc
 * @date 2023/12/27 09:43
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = {1, 4, 3, 5, 8, 4, 3};
        insertSort(a);
    }

    public static void insertSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int target = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > target) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = target;
        }

        for (int i : array) {
            System.out.println(i);
        }
    }
}
