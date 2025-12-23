package com.example.coding.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import org.apache.poi.ss.usermodel.Cell;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liutc
 * @date 2025/12/23 17:19
 */
public class DynamicFieldHandler implements CellWriteHandler {
    private final Set<String> hiddenFields; // 要隐藏的字段

    public DynamicFieldHandler(Map<String, Boolean> exportFieldMap) {
        this.hiddenFields = new HashSet<>();
        for (Map.Entry<String, Boolean> entry : exportFieldMap.entrySet()) {
            if (!entry.getValue()) {
                hiddenFields.add(getFieldNameForHeader(entry.getKey()));
            }
        }
    }

    @Override
    public void afterCellDispose(CellWriteHandlerContext context) {
        Boolean isHead = context.getHead();

        Cell cell = context.getCell();

        WriteSheetHolder writeSheetHolder = context.getWriteSheetHolder();

        if (isHead) {
            // 检查表头是否需要隐藏
            String headerValue = cell.getStringCellValue();
            if (hiddenFields.contains(headerValue)) {
                // 隐藏整列
                int columnIndex = cell.getColumnIndex();
                writeSheetHolder.getSheet().setColumnHidden(columnIndex, true);

                //或者删除表头单元格
                cell.setBlank();
            }
        } else {
            // 数据行：检查列是否被隐藏
            int columnIndex = cell.getColumnIndex();
            if (writeSheetHolder.getSheet().isColumnHidden(columnIndex)) {
                cell.setBlank(); // 清空数据
            }
        }
    }

    private String getFieldNameForHeader(String field) {
        // 映射字段名到表头名
        Map<String, String> fieldToHeader = new HashMap<>();
        fieldToHeader.put("username", "用户名");
        fieldToHeader.put("email", "邮箱");
        fieldToHeader.put("phone", "手机号");
        return fieldToHeader.get(field);
    }

    public static void main(String[] args) {
        List<UserDTO1> users = Arrays.asList(
                new UserDTO1("Alice", "alice@example.com", "123456789"),
                new UserDTO1("Bob", "bob@example.com", "987654321")
        );

        Map<String, Boolean> exportFieldMap = new HashMap<>();
        exportFieldMap.put("username", true);
        exportFieldMap.put("email", false);  // 不导出
        exportFieldMap.put("phone", true);

        String fileName = "/Users/liutongchun/Downloads/real_solution.xlsx";

        EasyExcel.write(fileName, UserDTO1.class)
                .registerWriteHandler(new DynamicFieldHandler(exportFieldMap))
                .sheet("Sheet1")
                .doWrite(users);

        System.out.println("导出完成，email列已隐藏");
    }
}
