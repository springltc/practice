package com.example.coding.thread;

public class ThreadlocalDemo {

    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("a");
        local.get();
    }
}
