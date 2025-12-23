package com.example.coding.excel;

import com.alibaba.excel.EasyExcel;

import java.util.Arrays;
import java.util.List;

/**
 * @author liutc
 * @date 2025/12/23 17:46
 */
public class ExportControlExample {
    public static void main(String[] args) {
        // 创建测试数据
        List<UserDTO> users = Arrays.asList(
                new UserDTO("张三", "zhangsan@example.com", "13800138000", 25),
                new UserDTO("李四", "lisi@example.com", null, -1),  // 手机号为null，年龄为负数
                new UserDTO("王五", "wangwu@example.com", "13700137000", 0)
        );

        String fileName = "export_control_demo.xlsx";

//        // 方法1：使用处理器方式
//        EasyExcel.write(fileName, UserDTO.class)
//                .registerWriteHandler(new ExportControlHandler(users))
//                .sheet("用户列表")
//                .doWrite(users);
//
//        System.out.println("方法1导出完成！");

        // 方法2：使用简化版控制器
        String fileName2 = "/Users/liutongchun/Downloads/export_control_simple.xlsx";
        SimpleExportController.createWriter(fileName2, UserDTO.class, users)
                .sheet("用户列表")
                .doWrite(users);

        System.out.println("方法2导出完成！");

        System.out.println("结果说明：");
        System.out.println("1. email列不会被导出（@ExportControl(export = false)）");
        System.out.println("2. 李四的手机号列为空（不符合条件）");
        System.out.println("3. 李四和王五的年龄列可能被隐藏（不符合条件）");
    }
}
