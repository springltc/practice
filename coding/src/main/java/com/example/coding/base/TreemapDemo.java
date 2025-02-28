package com.example.coding.base;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author liutc
 * @date 2025/1/4 15:53
 */
public class TreemapDemo {

    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>((a, b) -> {
            return a.compareTo(b);
        });
//        HashMap map = new HashMap<>();

        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("1", 4);

        System.out.println(map);
    }
}
