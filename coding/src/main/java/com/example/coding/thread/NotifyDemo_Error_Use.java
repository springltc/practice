package com.example.coding.thread;


public class NotifyDemo_Error_Use {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        System.out.println("wait()之前");
        object.wait();
        System.out.println("wait()之后");
    }
}
