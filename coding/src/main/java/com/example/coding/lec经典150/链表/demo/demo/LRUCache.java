package com.example.coding.lec经典150.链表.demo.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liutc
 * @date 2024/7/5 09:57
 */
public class LRUCache {

    class DoubleNode {
        int key;
        int value;
        DoubleNode prev;
        DoubleNode next;

        public DoubleNode() {
        }

        public DoubleNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DoubleNode> cache = new HashMap();

    private int capacity;
    private int size;
    private DoubleNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new DoubleNode();
        tail = new DoubleNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNodeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            removeNodeToHead(node);
        } else {
            node = new DoubleNode(key, value);
            addNodeToHead(node);
            cache.put(key, node);
            size++;
            if (size > capacity) {
                //移除最后一个
                DoubleNode removeTail = removeTail();
                cache.remove(removeTail.key);
                --size;
            }
        }
    }

    private DoubleNode removeTail() {
        DoubleNode res = tail.prev;
        res.prev.next = tail;
        tail.prev = res.prev;
        return res;
    }

    private void removeNodeToHead(DoubleNode node) {
        removeNode(node);
        addNodeToHead(node);
    }

    private void addNodeToHead(DoubleNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
