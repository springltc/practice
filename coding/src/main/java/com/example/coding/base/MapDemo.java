package com.example.coding.base;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * @author liutc
 * @date 2024/4/29 18:20
 */
public class MapDemo {

    public static void main(String[] args) {
        Multimap<String, String> multiMap = ArrayListMultimap.create();

        multiMap.put("a", "Fruit");
        multiMap.put("b", "Fruit");
        multiMap.put("c", "Fruit");

        // 获取键为"Fruit"的所有值
        System.out.println(multiMap.get("Fruit"));
    }
}
