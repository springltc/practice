package com.example.coding.lec经典150.位运算.简单;

/**
 * @author liutc
 * @date 2024/7/15 09:07
 */
public class 大于等于n的最小的2某次方 {

    public static final int near2power(int n) {
        if (n <= 0) {
            return 1;
        }
        n = n - 1;
        n = n | n >>> 1;
        n = n | n >>> 2;
        n = n | n >>> 4;
        n = n | n >>> 8;
        n = n | n >>> 16;
        return n + 1;
    }

    public static void main(String[] args) {
        int number = 100;
        int power = near2power(number);
        System.out.println(power);
    }
}
