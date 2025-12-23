package com.example.coding.excel.demo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.example.coding.excel.ExportControl;
import lombok.Data;

/**
 * @author liutc
 * @date 2025/12/23 17:45
 */
@Data
public class I18nUserDTO {
    @ExcelProperty("用户名")
    @I18nExportControl(exportCountry = CountryEnum.CHINA)  // 导出
    private String username;

    @ExcelProperty("邮箱")
    @I18nExportControl(exportCountry = CountryEnum.JAPAN)
    private String email;

    @ExcelProperty("手机号")
    @I18nExportControl(exportCountrys = {CountryEnum.JAPAN, CountryEnum.CHINA})
    private String phone;

    @ExcelProperty("年龄")
    private Integer age;

    // 构造方法
    public I18nUserDTO(String username, String email, String phone, Integer age) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

}
