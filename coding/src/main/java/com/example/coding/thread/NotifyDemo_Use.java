package com.example.coding.thread;


public class NotifyDemo_Use {

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();//创建一个锁对象
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(() -> {
                System.out.println("wait()之前");
                synchronized (locker) {//先进行加锁操作
                    try {
                        locker.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("wait()之后:" + Thread.currentThread().getName());
            });
            t1.start();
        }
        Thread.sleep(1000);//等待1s确保t1已经执行到wait
        Thread t2 = new Thread(() -> {
            System.out.println("notify()之前");
            synchronized (locker) {
                locker.notify();//唤醒线程t1
            }
            System.out.println("notify()之后");
        });
        t2.start();
    }
}
