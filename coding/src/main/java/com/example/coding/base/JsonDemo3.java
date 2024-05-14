package com.example.coding.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.xml.transform.Source;

/**
 * @author liutc
 * @date 2024/4/29 18:01
 */
public class JsonDemo3 {

    static String s = "{\"Size\": \"One Size\", \"Color\": \"Wine\"}";

    public static void main(String[] args) {
        JSONObject jsonObject = JSON.parseObject(s);

        jsonObject.put("Color", "abc");

        System.out.println(jsonObject);
        System.out.println(jsonObject);
    }
}
