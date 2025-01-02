package com.example.coding.demo;

import java.util.Arrays;

/**
 * @author liutc
 * @date 2024/9/9 18:28
 */
public class ListD {

    public static void main(String[] args) {
        String s = "12-34-56";
        String[] split = s.split("-");
        System.out.println(Arrays.toString(split));
    }

}
