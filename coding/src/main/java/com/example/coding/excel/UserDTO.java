package com.example.coding.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author liutc
 * @date 2025/12/23 17:45
 */
@Data
public class UserDTO {
    @ExcelProperty("用户名")
    @ExportControl(export = true)  // 导出
    private String username;

    @ExcelProperty("邮箱")
    @ExportControl(export = false) // 不导出
    private String email;

    @ExcelProperty("手机号")
    @ExportControl(
            export = true,
            condition = "#value != null && #value.length() == 11"  // 只有11位手机号才导出
    )
    private String phone;

    @ExcelProperty("年龄")
    @ExportControl(
            export = true,
            condition = "#value != null && #value > 0"  // 只有正数年龄才导出
    )
    private Integer age;

    // 构造方法
    public UserDTO(String username, String email, String phone, Integer age) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

}
