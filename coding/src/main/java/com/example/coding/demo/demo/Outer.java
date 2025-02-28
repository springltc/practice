package com.example.coding.demo.demo;

/**
 * @author liutc
 * @date 2025/2/15 12:16
 */
class Outer {
    private String message = "Hello from Outer!";

    public void method() {
        // 局部内部类
        class Inner {
            public void display() {
                System.out.println(message);  // 访问外部类的成员变量
            }
        }

        Inner inner = new Inner();
        inner.display();

        // 匿名内部类
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(message);  // 访问外部类的成员变量
            }
        };
        runnable.run();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.method();
    }
}

