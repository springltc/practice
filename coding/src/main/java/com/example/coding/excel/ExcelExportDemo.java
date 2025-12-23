package com.example.coding.excel;

import com.alibaba.excel.EasyExcel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liutc
 * @date 2025/12/23 15:39
 */
public class ExcelExportDemo {
    public static void main(String[] args) throws Exception {

        List<UserDTO1> users = Arrays.asList(
                new UserDTO1("Alice", "alice@example.com", "123456789"),
                new UserDTO1("Bob", "bob@example.com", "987654321")
        );

        // 动态控制字段导出
        Map<String, Boolean> exportFieldMap = new HashMap<>();
        exportFieldMap.put("username", true); // 导出
        exportFieldMap.put("email", false);   // 不导出
        exportFieldMap.put("phone", true);    // 导出

        String fileName = "dynamic_export.xlsx";

        EasyExcel.write(fileName, UserDTO1.class)
                .registerConverter(new ConditionalStringConverter(exportFieldMap, "username"))
                .registerConverter(new ConditionalStringConverter(exportFieldMap, "email"))
                .registerConverter(new ConditionalStringConverter(exportFieldMap, "phone"))
                .sheet("Sheet1")
                .doWrite(users);

        System.out.println("导出完成: " + fileName);
    }
}
