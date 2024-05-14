package com.example.coding.jvm;

/**
 * @author liutc
 * @date 2024/4/3 14:08
 */
public class GcTest {
    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1, allocation2;
        allocation1 = new byte[30900 * 1024 * 2 * 2];
        allocation2 = new byte[900 * 1024];
        Thread.sleep(1000 * 600);
    }
}
