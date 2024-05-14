package com.example.coding.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author liutc
 * @date 2024/4/4 17:06
 */
public class CompletableFuture_Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println("hello!-1"));
        future.get();// 输出 "hello!"
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "hello!-2");
        String s = future2.get();
        System.out.println(s);
    }
}
