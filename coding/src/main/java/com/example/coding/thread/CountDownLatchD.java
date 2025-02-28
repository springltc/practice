package com.example.coding.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author liutc
 * @date 2025/2/17 13:21
 */
public class CountDownLatchD {

    public static void main(String[] args) throws InterruptedException {
        // 创建一个 CountDownLatch，设置计数器为 3，表示主线程需要等待 3 个线程完成
        CountDownLatch latch = new CountDownLatch(3);

        // 创建并启动 3 个线程，每个线程执行一个任务
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            new Thread(() -> {
                try {
                    // 模拟任务执行
                    System.out.println("Task " + taskId + " is working...");
                    Thread.sleep((long) (Math.random() * 2000)); // 模拟随机的任务执行时间
                    System.out.println("Task " + taskId + " is done.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    // 每个线程完成任务后调用 countDown()，计数器减 1
                    latch.countDown();
                }
            }).start();
        }

        // 主线程在这里等待，直到 latch 的计数器为 0
        latch.await(); // 阻塞主线程，直到计数器减为 0

        // 当计数器为 0 时，主线程可以继续执行
        System.out.println("All tasks are finished. Main thread continues...");
    }

}
