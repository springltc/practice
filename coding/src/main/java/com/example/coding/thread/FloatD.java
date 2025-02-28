package com.example.coding.thread;

/**
 * @author liutc
 * @date 2025/2/18 07:52
 */
public class FloatD {

    public static void main(String[] args) {
        float a = 2.0f - 1.9f;
        float b = 1.8f - 1.7f;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999905
        System.out.println(a == b);// false


    }
}
