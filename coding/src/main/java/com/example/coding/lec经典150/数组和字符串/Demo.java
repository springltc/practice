package com.example.coding.lec经典150.数组和字符串;

import java.util.Arrays;

/**
 * @author liutc
 * @date 2024/5/15 08:43
 */
public class Demo {

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
