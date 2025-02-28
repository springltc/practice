package com.example.coding.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author liutc
 * @date 2025/2/15 13:55
 */
public class Main {
    public static void main(String[] args) {
        Thread childThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("I'm child thread..");
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        childThread.setDaemon(true);
        childThread.start();
        System.out.println("I'm main thread...");
    }
}
