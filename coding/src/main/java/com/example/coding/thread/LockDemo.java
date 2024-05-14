package com.example.coding.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liutc
 * @date 2024/4/2 14:23
 */
public class LockDemo {

    private static ReentrantLock lock = new ReentrantLock();
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 100; j++) {
            new Thread(LockDemo::method).start();
        }
        Thread.sleep(2000);
        System.out.println(i);
    }

    static void method() {
        lock.lock();
        i = i + 1;
        lock.unlock();
    }
}
