package com.example.coding.lec经典150;

import java.util.concurrent.CompletableFuture;
import java.util.regex.Pattern;

/**
 * @author liutc
 * @date 2024/2/6 14:21
 */
public class Demo {

    private static String pattern = "detail.1688.com/offer/(\\d+)\\.html(.*)";
    private static Pattern r = Pattern.compile(pattern);

    public static void main(String[] args) {
//        String s = "Hello, World!123";
//        String result = s.replaceAll("[^a-zA-Z0-9]", "");
//        System.out.println(result);

//        String s = "https://detail.1688.com/offer/604782484235.html?spm=a26286.10576602.0.0";
//        Matcher m = r.matcher(s);
//        if (m.find()) {
//            Long productId = Long.valueOf(m.group(1));
//        }

        for (int i = 0; i < 1000; i++) {
            CompletableFuture.runAsync(()-> System.out.println(Thread.currentThread().getName()));
        }
    }

    public static void method1() {

    }

    public static void method2() {

    }
}
