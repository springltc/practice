package com.example.coding;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterExample {
    public static void main(String[] args) {
        // 创建布隆过滤器，预计插入100个元素，误判率为0.01
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 100, 0.01);

        // 插入元素
        bloomFilter.put("Hollis");
        bloomFilter.put("666");
        bloomFilter.put("八股文");

        // 判断元素是否存在
        System.out.println(bloomFilter.mightContain("Hollis")); // true
        System.out.println(bloomFilter.mightContain("王星星"));  // false
    }
}
