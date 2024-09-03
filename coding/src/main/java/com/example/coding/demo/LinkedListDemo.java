package com.example.coding.demo;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author liutc
 * @date 2024/8/9 09:43
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        System.out.println(list);
    }
}
