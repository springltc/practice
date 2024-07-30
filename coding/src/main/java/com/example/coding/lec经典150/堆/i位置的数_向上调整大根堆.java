package com.example.coding.lec经典150.堆;

/**
 * @author liutc
 * @date 2024/7/30 11:02
 */
public class i位置的数_向上调整大根堆 {

    public static int MAXN = 100001;

    public static int[] arr = new int[MAXN];

    public static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
