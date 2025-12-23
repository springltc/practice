package com.example.coding.json.model;

import com.example.coding.json.serializer.CustomDateSerializer;
import com.example.coding.json.serializer.EnumSerializer;
import com.example.coding.json.serializer.MaskedSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;

/**
 * @author liutc
 * @date 2025/12/22 18:21
 */
@Data
public class User {
    private Long id;
    private String name;

    // 场景1: 格式化日期
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date createTime;

    //场景2: 隐藏敏感信息
    @JsonSerialize(using = MaskedSerializer.class)
    private String password;

    // 场景3: 转换枚举值
    @JsonSerialize(using = EnumSerializer.class)
    private Status status;

    public User(Long id, String name, Date createTime, String password, Status status) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.password = password;
        this.status = status;
    }
}
