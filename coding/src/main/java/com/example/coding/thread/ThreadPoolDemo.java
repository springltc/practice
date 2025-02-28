package com.example.coding.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        poolExecutor.execute(() -> System.out.println("122"));
        poolExecutor.execute(() -> System.out.println("122"));
        poolExecutor.execute(() -> System.out.println("122"));
    }
}
