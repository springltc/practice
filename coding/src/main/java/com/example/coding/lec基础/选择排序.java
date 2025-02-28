package com.example.coding.lec基础;

/**
 * @author liutc
 * @date 2025/1/16 14:25
 */
public class 选择排序 {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 9, 5};
        selectSort(arr);
        System.out.println(arr);
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            //交换
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
