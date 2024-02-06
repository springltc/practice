package com.example.coding.algorithm;

/**
 * @author liutc
 * @date 2023/12/26 10:04
 */
public class 选择排序 {

    /**
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     */
    public static void main(String[] args) {
        int[] a = {1, 4, 3, 5, 8, 4, 3};
        selectionSort(a);
    }

    /**
     * 1
     * 3
     * 3
     * 4
     * 4
     * 5
     * 8
     *
     * @param array
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index])
                    index = j;
            }
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }

        for (int i : array) {
            System.out.println(i);
        }
    }

}
