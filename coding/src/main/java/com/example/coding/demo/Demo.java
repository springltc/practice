package com.example.coding.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liutc
 * @date 2024/5/13 09:36
 */
public class Demo {

    public static void main(String[] args) {
        List<String> spuCodes = Arrays.stream(" ".trim().split(",")).map(String::trim).collect(Collectors.toList());
        System.out.println(spuCodes);
    }
}
