package com.example.coding.base;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liutc
 * @date 2024/4/29 17:38
 */
public class Demo {

    public static void main(String[] args) {
        List<Object> colorValues = new ArrayList<>();
        colorValues.add("a");
        colorValues.add("b");
        colorValues.add("1");

        JSONArray jsonArray = new JSONArray(colorValues);

        // 打印转换后的JSONArray
        System.out.println(jsonArray.toString());
    }
}
