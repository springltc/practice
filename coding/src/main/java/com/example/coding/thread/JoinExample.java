package com.example.coding.thread;

/**
 * @author liutc
 * @date 2025/2/17 08:09
 */
public class JoinExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 is running.");
            try {
                Thread.sleep(1000);  // 模拟一些工作
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread 1 has finished.");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 is running.");
            try {
                Thread.sleep(500);  // 模拟一些工作
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread 2 has finished.");
        });

        thread1.start();
        thread2.start();

//        try {
//            thread1.join();  // 主线程等待 thread1 执行完成
//            thread2.join();  // 主线程等待 thread2 执行完成
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }

        System.out.println("Main thread has finished.");
    }
}
