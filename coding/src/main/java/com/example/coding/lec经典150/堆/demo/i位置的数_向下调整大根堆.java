package com.example.coding.lec经典150.堆.demo;

/**
 * @author liutc
 * @date 2024/7/30 11:02
 */
public class i位置的数_向下调整大根堆 {

    public static int MAXN = 100001;

    public static int[] arr = new int[MAXN];

    public static void heapify(int[] arr, int i, int size) {
        int l = i * 2 + 1;
        while (l < size) {
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;
            best = arr[best] > arr[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(arr, i, best);

            i = best;
            l = best * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int best) {
        int tem = arr[i];
        arr[i] = arr[best];
        arr[best] = tem;
    }

}
