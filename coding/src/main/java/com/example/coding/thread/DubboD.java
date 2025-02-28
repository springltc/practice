package com.example.coding.thread;

/**
 * @author liutc
 * @date 2025/2/18 07:52
 */
public class DubboD {

    public static void main(String[] args) {
        double a = 2.0f - 1.9f;
        double b = 1.8f - 1.7f;
//        double a = 2.0d - 1.5d;
//        double b = 1.8d - 1.3d;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999905
        System.out.println(a == b);// false


    }
}
