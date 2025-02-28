package com.example.coding.lec基础.排序;

/**
 * @author liutc
 * @date 2025/1/16 15:33
 */
public class 插入排序 {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        insertSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
