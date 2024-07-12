package com.example.coding.lec经典150.位运算;

/**
 * @author liutc
 * @date 2024/7/12 09:13
 */
public class Demo {

    public static void main(String[] args) {
        //异或 (相当于无进位想加)
        int a = 5;
        int b = 10;

        //a ^ 0 = a
        int v1 = a ^ 0;
        System.out.println(v1);
        //a ^ a = 0
        int v2 = a ^ a;
        System.out.println(v2);
        //交换 (^满足交换律和结合律)
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
    }
}
