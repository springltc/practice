package com.example.coding.thread;

import java.math.BigDecimal;

/**
 * @author liutc
 * @date 2025/2/18 07:59
 */
public class BigDecimalD {

    public static void main(String[] args) {
//        BigDecimal v1 = BigDecimal.valueOf(1.0);
//        BigDecimal v2 = BigDecimal.valueOf(1.00);

        BigDecimal v1 = new BigDecimal("1");
        BigDecimal v2 = new BigDecimal("1.0");

        System.out.println(v1.compareTo(v2) == 0);
        System.out.println(v1.equals(v2));

    }

}
