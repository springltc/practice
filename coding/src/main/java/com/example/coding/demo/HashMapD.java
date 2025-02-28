package com.example.coding.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liutc
 * @date 2025/2/15 11:49
 */
public class HashMapD {

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("2","null");
        System.out.println(map.get(2));
        System.out.println(map.get(3));

//        Integer integer = Integer.valueOf(5);
//        Integer integer2 = Integer.valueOf(5);
//
//        System.out.println(integer2 == integer);
//        System.out.println(integer2.equals(integer));


        float f = 3.14f; // 使用f后缀声明float类型的常量
        double d = 3.14; // 默认是double类型的常量

        f = (float) d;  // 强制类型转换
        d = f; // 将float类型的值赋给double类型

        System.out.println("f = " + f);
        System.out.println("d = " + d);
    }


}
