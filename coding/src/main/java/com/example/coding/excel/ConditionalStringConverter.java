package com.example.coding.excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;

import java.util.Map;

/**
 * @author liutc
 * @date 2025/12/23 14:16
 */
public class ConditionalStringConverter implements Converter<String> {
    private final Map<String, Boolean> exportFieldMap;
    private final String fieldName;

    public ConditionalStringConverter(Map<String, Boolean> exportFieldMap, String fieldName) {
        this.exportFieldMap = exportFieldMap;
        this.fieldName = fieldName;
    }

    @Override
    public Class supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public WriteCellData<String> convertToExcelData(WriteConverterContext<String> context) {
        Boolean export = exportFieldMap.getOrDefault(fieldName, true);
        if (export) {
            return new WriteCellData<>(context.getValue());
        } else {
            return null; // 不写入单元格，相当于动态忽略字段
        }
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

}
