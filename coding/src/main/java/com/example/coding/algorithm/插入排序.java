package com.example.coding.algorithm;

import java.util.Arrays;

/**
 * @author liutc
 * @date 2023/12/26 17:36
 */
public class 插入排序 {

    /**
     * 插入排序的步骤可以简单概括为以下几个阶段：
     * <p>
     * 初始状态： 将数组的第一个元素视为已排序部分，其余部分为未排序部分。
     * 逐个插入： 从未排序部分选择一个元素，将其插入到已排序部分的正确位置。为了插入，将已排序部分中大于待插入元素的元素向右移动一个位置。
     * 重复： 重复上述插入步骤，直到所有元素都被插入到已排序部分。
     * 完成： 当算法完成时，整个数组就被排序了。
     * <p>
     * 作者：修己xj
     * 链接：https://juejin.cn/post/7284881709044744251
     * 来源：稀土掘金
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 4, 6, 7, 1, 3};
        insertionSort(arr);
    }

    public static void insertionSort(int[] arr) {
        //获取数组长度
        int len = arr.length;
        // 循环 len-1 次，进行数组排序。第一次将数组的第一个元素视为已排序的部分，
        // 每次将未排序部分的第一个元素插入到已排序的部分。
        for (int i = 1; i < len; i++) {
            //目标元素，未排序部分的第一个元素，即当前循环中要插入排序的元素
            int target = arr[i];
            //已排序元素中的最后一个元素的下标
            int j = i - 1;

            // 循环已排序的部分的数组，找到目标元素应该存放的下标
            while (j >= 0 && arr[j] > target) {
                // 如果插入元素小于当前元素，则将当前元素后移一位
                arr[j + 1] = arr[j];
                // 当前已排序的数据比较元素的下标前移一位
                j--;
            }
            //将目标元素插入到正确的位置
            arr[j + 1] = target;
        }
    }

    // 插入排序，a表示数组，n表示数组大小
    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }
}
