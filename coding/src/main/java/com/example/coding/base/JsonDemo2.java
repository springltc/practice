package com.example.coding.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author liutc
 * @date 2024/4/29 17:56
 */
public class JsonDemo2 {

    static String s = "{\n" +
            "\t\"Size\": {\n" +
            "\t\t\"id\": 5,\n" +
            "\t\t\"value\": \"One Size\",\n" +
            "\t\t\"typeId\": 1\n" +
            "\t},\n" +
            "\t\"Color\": {\n" +
            "\t\t\"id\": 12,\n" +
            "\t\t\"img\": \"\",\n" +
            "\t\t\"sort\": 1,\n" +
            "\t\t\"label\": \"Wine\",\n" +
            "\t\t\"tmpId\": \"Wine\",\n" +
            "\t\t\"value\": \"Wine\",\n" +
            "\t\t\"remark\": \"酒红\",\n" +
            "\t\t\"typeId\": 2,\n" +
            "\t\t\"groupId\": 4,\n" +
            "\t\t\"disabled\": false,\n" +
            "\t\t\"attrImage\": \"https://shobby-s.s3.us-west-2.amazonaws.com/test/0092ef5e8fff4a8aa32134bb6a989caf-Max.jpg\",\n" +
            "\t\t\"colorType\": 1,\n" +
            "\t\t\"allowCustom\": 0,\n" +
            "\t\t\"customProps\": {\n" +
            "\t\t\t\"color\": \"831010\"\n" +
            "\t\t}\n" +
            "\t}\n" +
            "}";

    public static void main(String[] args) {
        JSONObject jsonObject = JSON.parseObject(s);
        JSONObject color = jsonObject.getJSONObject("Color");
        System.out.println(color);
        System.out.println(color);
    }
}
