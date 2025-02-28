package com.example.coding.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author liutc
 * @date 2025/2/15 14:07
 */
public class FutureTaskD {


    public static void main(String[] args) throws Exception {
        // 创建一个 Callable 对象
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 10; i++) {
                    sum += i;
                    Thread.sleep(500); // 模拟任务处理的延时
                }
                return sum; // 返回任务结果
            }
        };

        // 创建 FutureTask，包装 Callable 对象
        FutureTask<Integer> futureTask = new FutureTask<>(task);

        // 创建并启动线程
        Thread thread = new Thread(futureTask);
        thread.start();

        // 在任务执行过程中，我们可以做一些其他的事情
        System.out.println("Main thread is doing other work...");

        // 获取任务执行结果，若任务未完成，会阻塞直到结果返回
        Integer result = futureTask.get();
        System.out.println("Task result: " + result);
    }
}
