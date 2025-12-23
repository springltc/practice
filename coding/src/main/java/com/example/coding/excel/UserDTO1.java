package com.example.coding.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author liutc
 * @date 2025/12/23 14:08
 */
@Data
public class UserDTO1 {
    @ExcelProperty("用户名")
    private String username;

    @ExcelProperty("邮箱")
    private String email;

    @ExcelProperty("手机号")
    private String phone;

    public UserDTO1(String username, String email, String phone) {
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

}
