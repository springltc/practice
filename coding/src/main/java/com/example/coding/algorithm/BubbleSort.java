package com.example.coding.algorithm;

/**
 * @author liutc
 * @date 2023/12/26 09:54
 */
public class BubbleSort {

    public static void main(String[] args) {
//        int[] a = {1, 4, 3, 5, 8, 4, 3};
        int[] a = {6, 5, 4, 3, 2, 1, 0};
        bubbleSort(a);
    }

    public static void bubbleSort(int[] array) {
        if (array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tem = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tem;
                }
            }
        }

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void bubbleSortV2(int[] array) {
        if (array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tem = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tem;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
