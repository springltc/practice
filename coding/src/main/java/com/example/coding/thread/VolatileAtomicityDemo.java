package com.example.coding.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liutc
 * @date 2024/3/28 16:21
 */
public class VolatileAtomicityDemo {
    public volatile static int inc = 0;

    public void increase() {
        /**
         * 读取 inc 的值。
         * 对 inc 加 1。
         * 将 inc 的值写回内存。
         * volatile 是无法保证这三个操作是具有原子性的
         * 这也就导致两个线程分别对 inc 进行了一次自增操作后，inc 实际上只增加了 1。
         */
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatileAtomicityDemo volatileAtomicityDemo = new VolatileAtomicityDemo();
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 500; j++) {
                    volatileAtomicityDemo.increase();
                }
            });
        }
        // 等待1.5秒，保证上面程序执行完成
        Thread.sleep(1500);
        System.out.println(inc);
        threadPool.shutdown();
    }
}
