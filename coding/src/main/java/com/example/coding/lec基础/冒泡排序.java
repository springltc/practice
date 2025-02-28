package com.example.coding.lec基础;

/**
 * @author liutc
 * @date 2025/1/16 14:51
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mpSort(arr);
        System.out.println(arr);
    }

    public static void mpSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int length = arr.length;
        for (int end = length - 1; end >= 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
}
