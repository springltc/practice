package com.example.coding.thread;

import java.util.concurrent.SynchronousQueue;

/**
 * @author liutc
 * @date 2024/4/23 17:01
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        synchronousQueue.put("a");
    }
}
