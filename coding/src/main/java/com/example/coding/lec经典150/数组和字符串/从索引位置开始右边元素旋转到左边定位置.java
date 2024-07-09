package com.example.coding.lec经典150.数组和字符串;

import java.util.Arrays;

/**
 * @author liutc
 * @date 2024/7/9 17:32
 */
public class 从索引位置开始右边元素旋转到左边定位置 {

    //从索引改成元素的移动,利用取余算法
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        //4 5 6 7 1 2 3
        int k = 2;
        int move = arr.length - (k + 1); //4
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[(i + move) % arr.length] = arr[i];
        }
        System.out.println(Arrays.toString(res));
    }
}
