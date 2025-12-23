package com.example.coding.excel.demo;

import com.example.coding.excel.SimpleExportController;
import com.example.coding.excel.UserDTO;

import java.util.Arrays;
import java.util.List;

/**
 * @author liutc
 * @date 2025/12/23 17:46
 */
public class I18nExportControlExample {
    public static void main(String[] args) {
        // 创建测试数据
        List<I18nUserDTO> users = Arrays.asList(
                new I18nUserDTO("张三", "zhangsan@example.com", "13800138000", 25),
                new I18nUserDTO("李四", "lisi@example.com", null, -1),  // 手机号为null，年龄为负数
                new I18nUserDTO("王五", "wangwu@example.com", "13700137000", 0)
        );

        // 方法2：使用简化版控制器
        String fileName2 = "/Users/liutongchun/Downloads/export_control_simple.xlsx";
        I18nExportController.createWriter(fileName2, I18nUserDTO.class, users)
                .sheet("用户列表")
                .doWrite(users);

        System.out.println("方法2导出完成！");

        System.out.println("结果说明：");
        System.out.println("1. 用户名 不导出");
    }
}
