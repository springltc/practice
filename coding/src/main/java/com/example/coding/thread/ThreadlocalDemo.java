package com.example.coding.thread;

/**
 * @author liutc
 * @date 2024/3/28 17:57
 */
public class ThreadlocalDemo {

    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("a");
        local.get();
    }
}
