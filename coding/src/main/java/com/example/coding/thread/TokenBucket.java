package com.example.coding.thread;

import com.google.common.util.concurrent.RateLimiter;

public class TokenBucket {
    private RateLimiter rateLimiter;

    public TokenBucket(double permitsPerSecond) {
        this.rateLimiter = RateLimiter.create(permitsPerSecond);
    }

    public void acquire() {
        this.rateLimiter.acquire();
        // 执行需要限流的操作
    }

    public static void main(String[] args) {
        TokenBucket tokenBucket = new TokenBucket(2); // 每秒产生10个令牌
        for (int i = 0; i < 20; i++) {
            // 模拟有20个请求需要处理
            new Thread(() -> {
                tokenBucket.acquire();
                System.out.println("Request processed.");
            }).start();
        }
    }
}

