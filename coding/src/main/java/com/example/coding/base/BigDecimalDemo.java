package com.example.coding.base;

import java.math.BigDecimal;

/**
 * @author liutc
 * @date 2024/4/24 14:10
 */
public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(1);
        BigDecimal bigDecimal1 = new BigDecimal(1);
        System.out.println(bigDecimal.equals(bigDecimal1));


        BigDecimal bigDecimal2 = new BigDecimal(1);
        BigDecimal bigDecimal3 = new BigDecimal(1.0);
        System.out.println(bigDecimal2.equals(bigDecimal3));


        BigDecimal bigDecimal4 = new BigDecimal("1");
        BigDecimal bigDecimal5 = new BigDecimal("1.0");
        System.out.println(bigDecimal4.equals(bigDecimal5));
    }
}
