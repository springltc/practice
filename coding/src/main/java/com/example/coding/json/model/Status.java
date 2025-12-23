package com.example.coding.json.model;

/**
 * @author liutc
 * @date 2025/12/22 18:36
 */
public enum Status {
    ENABLED(1, "启用"),
    DISABLED(0, "禁用");

    private final int code;
    private final String desc;

    Status(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
