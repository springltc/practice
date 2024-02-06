package com.example.coding.demo;

/**
 * @author liutc
 * @date 2023/12/25 09:56
 */
public class ArrayD {

    public static void main(String[] args) {
        System.out.println(f(1));
        System.out.println(f(2));
        System.out.println(f(3));
        System.out.println(f(4));
        System.out.println(f(5));
        System.out.println(f(6));
        System.out.println(f(7));
    }

    //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
    public static void a() {
        int[] a = new int[3];
        a[3] = 0;
    }

    public static int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return f(n - 1) + f(n - 2);
    }
}
