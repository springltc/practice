package com.example.coding.lec经典150.链表;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liutc
 * @date 2024/7/4 17:16
 * <p>
 * 最近最少使用
 * <p>
 * 这些做法都不会符合面试官的要求-->就是说不能使用现成的框架
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        //true，则LinkedHashMap将使用访问顺序来维护条目的顺序。这意味着当一个条目被访问时（通过get方法或遍历条目），它会被移到链表的末尾，使得最近访问的条目在最后
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
