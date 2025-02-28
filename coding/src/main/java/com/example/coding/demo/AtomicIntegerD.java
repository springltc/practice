package com.example.coding.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liutc
 * @date 2025/2/12 23:03
 */
public class AtomicIntegerD {

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();
        System.out.println(integer.getAndIncrement());
//        int v = integer.incrementAndGet();
//        System.out.println(v);
//        v = integer.incrementAndGet();
//        System.out.println(v);
    }
}
