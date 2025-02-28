package com.example.coding.lec基础;

/**
 * @author liutc
 * @date 2025/1/16 15:33
 */
public class 插入排序 {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        insertSort(arr);
        System.out.println(arr);
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }

}
