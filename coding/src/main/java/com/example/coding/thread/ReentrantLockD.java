package com.example.coding.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liutc
 * @date 2025/2/17 13:19
 */
public class ReentrantLockD {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();
    }
}
