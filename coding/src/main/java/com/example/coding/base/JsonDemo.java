package com.example.coding.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.Objects;

/**
 * @author liutc
 * @date 2024/4/29 16:05
 */
public class JsonDemo {

    static String s = "{\n" +
            "\t\"Size\": [{\n" +
            "\t\t\"id\": 146,\n" +
            "\t\t\"img\": \"\",\n" +
            "\t\t\"sort\": 1,\n" +
            "\t\t\"label\": \"One Size\",\n" +
            "\t\t\"tmpId\": \"One Size\",\n" +
            "\t\t\"value\": \"One Size\",\n" +
            "\t\t\"remark\": \"One Size\",\n" +
            "\t\t\"typeId\": 1,\n" +
            "\t\t\"groupId\": 20,\n" +
            "\t\t\"disabled\": false,\n" +
            "\t\t\"colorType\": 1,\n" +
            "\t\t\"allowCustom\": 0,\n" +
            "\t\t\"customProps\": {}\n" +
            "\t}],\n" +
            "\t\"Color\": [{\n" +
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
            "\t}, {\n" +
            "\t\t\"id\": 254,\n" +
            "\t\t\"img\": \"\",\n" +
            "\t\t\"sort\": 5,\n" +
            "\t\t\"label\": \"Chestnut\",\n" +
            "\t\t\"tmpId\": \"Chestnut\",\n" +
            "\t\t\"value\": \"Chestnut\",\n" +
            "\t\t\"remark\": \"栗粽色\",\n" +
            "\t\t\"typeId\": 2,\n" +
            "\t\t\"groupId\": 6,\n" +
            "\t\t\"disabled\": false,\n" +
            "\t\t\"attrImage\": \"https://shobby-s.s3.us-west-2.amazonaws.com/test/7d4e9210281d465bad961d45d5575849-Max.jpg\",\n" +
            "\t\t\"colorType\": 1,\n" +
            "\t\t\"allowCustom\": 0,\n" +
            "\t\t\"customProps\": {\n" +
            "\t\t\t\"color\": \"80471C\"\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": 37,\n" +
            "\t\t\"img\": \"\",\n" +
            "\t\t\"sort\": 2,\n" +
            "\t\t\"label\": \"Ivory\",\n" +
            "\t\t\"tmpId\": \"Ivory\",\n" +
            "\t\t\"value\": \"Ivory\",\n" +
            "\t\t\"remark\": \"象牙白\",\n" +
            "\t\t\"typeId\": 2,\n" +
            "\t\t\"groupId\": 7,\n" +
            "\t\t\"disabled\": false,\n" +
            "\t\t\"attrImage\": \"https://shobby-s.s3.us-west-2.amazonaws.com/test/fa3603d9e583460cb98084f5a9ef9f85-Max.jpg\",\n" +
            "\t\t\"colorType\": 1,\n" +
            "\t\t\"allowCustom\": 0,\n" +
            "\t\t\"customProps\": {\n" +
            "\t\t\t\"color\": \"FFFFF0\"\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": 96,\n" +
            "\t\t\"img\": \"\",\n" +
            "\t\t\"sort\": 7,\n" +
            "\t\t\"label\": \"Navy\",\n" +
            "\t\t\"tmpId\": \"Navy\",\n" +
            "\t\t\"value\": \"Navy\",\n" +
            "\t\t\"remark\": \"深蓝\",\n" +
            "\t\t\"typeId\": 2,\n" +
            "\t\t\"groupId\": 9,\n" +
            "\t\t\"disabled\": false,\n" +
            "\t\t\"attrImage\": \"https://shobby-s.s3.us-west-2.amazonaws.com/test/c569117fd30545a68f75b8a77ed591db-Max.jpg\",\n" +
            "\t\t\"colorType\": 1,\n" +
            "\t\t\"allowCustom\": 0,\n" +
            "\t\t\"customProps\": {\n" +
            "\t\t\t\"color\": \"03098C\"\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": 78,\n" +
            "\t\t\"img\": \"\",\n" +
            "\t\t\"sort\": 9,\n" +
            "\t\t\"label\": \"Tangerine\",\n" +
            "\t\t\"tmpId\": \"Tangerine\",\n" +
            "\t\t\"value\": \"Tangerine\",\n" +
            "\t\t\"remark\": \"橘色\",\n" +
            "\t\t\"typeId\": 2,\n" +
            "\t\t\"groupId\": 11,\n" +
            "\t\t\"disabled\": false,\n" +
            "\t\t\"attrImage\": \"https://shobby-s.s3.us-west-2.amazonaws.com/test/8402b34be74d4ef0a81a5d5e250b19eb-Max.jpg\",\n" +
            "\t\t\"colorType\": 1,\n" +
            "\t\t\"allowCustom\": 0,\n" +
            "\t\t\"customProps\": {\n" +
            "\t\t\t\"color\": \"FEA500\"\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": 286,\n" +
            "\t\t\"img\": \"\",\n" +
            "\t\t\"sort\": 23,\n" +
            "\t\t\"label\": \"Deep Red\",\n" +
            "\t\t\"tmpId\": \"Deep Red\",\n" +
            "\t\t\"value\": \"Deep Red\",\n" +
            "\t\t\"remark\": \"深红\",\n" +
            "\t\t\"typeId\": 2,\n" +
            "\t\t\"groupId\": 4,\n" +
            "\t\t\"disabled\": false,\n" +
            "\t\t\"attrImage\": \"https://shobby-s.s3.us-west-2.amazonaws.com/test/1e03ffbbc1cc45aab3f28b981b9a4f73-Max.jpg\",\n" +
            "\t\t\"colorType\": 1,\n" +
            "\t\t\"allowCustom\": 0,\n" +
            "\t\t\"customProps\": {\n" +
            "\t\t\t\"color\": \"D0082C\"\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": 28,\n" +
            "\t\t\"img\": \"\",\n" +
            "\t\t\"sort\": 15,\n" +
            "\t\t\"label\": \"Blush Pink\",\n" +
            "\t\t\"tmpId\": \"Blush Pink\",\n" +
            "\t\t\"value\": \"Blush Pink\",\n" +
            "\t\t\"remark\": \"浅粉\",\n" +
            "\t\t\"typeId\": 2,\n" +
            "\t\t\"groupId\": 4,\n" +
            "\t\t\"disabled\": false,\n" +
            "\t\t\"attrImage\": \"https://shobby-s.s3.us-west-2.amazonaws.com/test/d4e9eb83540143d4b9357de4b292e53c-Max.jpg\",\n" +
            "\t\t\"colorType\": 1,\n" +
            "\t\t\"allowCustom\": 0,\n" +
            "\t\t\"customProps\": {\n" +
            "\t\t\t\"color\": \"F5CCDA\"\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": 83,\n" +
            "\t\t\"img\": \"\",\n" +
            "\t\t\"sort\": 3,\n" +
            "\t\t\"label\": \"Dark Gray\",\n" +
            "\t\t\"tmpId\": \"Dark Gray\",\n" +
            "\t\t\"value\": \"Dark Gray\",\n" +
            "\t\t\"remark\": \"深灰\",\n" +
            "\t\t\"typeId\": 2,\n" +
            "\t\t\"groupId\": 8,\n" +
            "\t\t\"disabled\": false,\n" +
            "\t\t\"attrImage\": \"https://shobby-s.s3.us-west-2.amazonaws.com/test/ad2f8c02f3f443629d9c27f19e5fd57e-Max.jpg\",\n" +
            "\t\t\"colorType\": 1,\n" +
            "\t\t\"allowCustom\": 0,\n" +
            "\t\t\"customProps\": {\n" +
            "\t\t\t\"color\": \"615F60\"\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"id\": 74,\n" +
            "\t\t\"img\": \"\",\n" +
            "\t\t\"sort\": 5,\n" +
            "\t\t\"label\": \"Banana Yellow\",\n" +
            "\t\t\"tmpId\": \"Banana Yellow\",\n" +
            "\t\t\"value\": \"Banana Yellow\",\n" +
            "\t\t\"remark\": \"明黄色\",\n" +
            "\t\t\"typeId\": 2,\n" +
            "\t\t\"groupId\": 11,\n" +
            "\t\t\"disabled\": false,\n" +
            "\t\t\"attrImage\": \"https://shobby-s.s3.us-west-2.amazonaws.com/test/e524399c0f2d45069828cc4641d0a5d9-Max.jpg\",\n" +
            "\t\t\"colorType\": 1,\n" +
            "\t\t\"allowCustom\": 0,\n" +
            "\t\t\"customProps\": {\n" +
            "\t\t\t\"color\": \"FCEC50\"\n" +
            "\t\t}\n" +
            "\t}]\n" +
            "}";

    public static void main(String[] args) {
        JSONObject jsonObject = JSON.parseObject(s);
        JSONArray color = jsonObject.getJSONArray("Color");
        if (Objects.isNull(color) || color.isEmpty()) {
            return;
        }
        for (int i = 0; i < color.size(); i++) {
            JSONObject colorInfo = color.getJSONObject(i);
            if (Objects.isNull(colorInfo)) {
                return;
            }
            //老数据手动输入的不处理
            Integer groupId = colorInfo.getInteger("groupId");
            if (Objects.isNull(groupId) || Objects.equals(groupId, 0)) {
                return;
            }
            //自定义的不处理
            Integer allowCustom = colorInfo.getInteger("allowCustom");
            if (Objects.isNull(allowCustom) || Objects.equals(allowCustom, 1)) {
                return;
            }

            Long id = colorInfo.getLong("id");
            String value = colorInfo.getString("value");
            String customProps = colorInfo.getString("customProps");
        }

    }
}
