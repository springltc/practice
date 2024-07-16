package com.example.coding.thread;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        synchronousQueue.put("a");
    }
}
