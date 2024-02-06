package com.example.coding.algorithm;

import org.apache.tomcat.Jar;

import javax.xml.transform.Source;

/**
 * @author liutc
 * @date 2023/12/26 16:48
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = {1, 4, 3, 5, 8, 4, 3};
        selectSort(a);

        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            int tem = array[index];
            array[index] = array[i];
            array[i] = tem;
        }
    }
}
