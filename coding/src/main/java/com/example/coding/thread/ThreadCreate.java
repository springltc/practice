package com.example.coding.thread;

import sun.util.resources.cldr.lo.CalendarData_lo_LA;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author liutc
 * @date 2024/3/29 16:39
 */
public class ThreadCreate {

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            System.out.println("线程1执行");
        }).start();

        new Thread(new ThreadA()).start();
        FutureTask<String> futureTask = new FutureTask<>(new ThreadB());
        new Thread(futureTask).start();
        String result = futureTask.get();
        System.out.println(result);

        new ThreadB().call();
    }

    public static class ThreadA implements Runnable {

        @Override
        public void run() {
            System.out.println("线程2执行");
        }
    }

    public static class ThreadB implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("线程3执行:" + Thread.currentThread().getName());
            return "abc";
        }
    }
}
