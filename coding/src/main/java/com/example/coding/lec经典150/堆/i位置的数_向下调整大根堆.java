package com.example.coding.lec经典150.堆;

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
            // 有左孩子，l
            // 右孩子，l+1
            // 评选，最强的孩子，是哪个下标的孩子
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;
            // 上面已经评选了最强的孩子，接下来，当前的数和最强的孩子之前，最强下标是谁
            best = arr[best] > arr[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(arr, best, i);
            i = best;
            l = i * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
