package com.example.coding.excel.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.example.coding.excel.ExportControl;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author liutc
 * @date 2025/12/23 17:43
 */
public class I18nExportController {

    private static final String countTry = "HK";

    /**
     * 创建支持注解控制的Excel写入器
     */
    public static ExcelWriterBuilder createWriter(String fileName, Class<?> clazz, List<?> data) {
        // 分析哪些字段需要排除
        Set<String> excludeFields = analyzeExcludeFields(clazz, data);

        // 创建写入器
        ExcelWriterBuilder writer = EasyExcel.write(fileName, clazz);

        // 排除不需要导出的字段
        if (!excludeFields.isEmpty()) {
            writer.excludeColumnFieldNames(excludeFields);
        }

        return writer;
    }

    /**
     * 分析需要排除的字段
     */
    private static Set<String> analyzeExcludeFields(Class<?> clazz, List<?> data) {
        Set<String> excludeFields = new HashSet<>();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            // 检查@ExportControl注解
            I18nExportControl exportControl = field.getAnnotation(I18nExportControl.class);
            if (Objects.nonNull(exportControl)) {
                CountryEnum countryEnum = exportControl.exportCountry();
                switch (countryEnum) {
                    case ALL:
                        break;
                    case OVERSEAS:
                        if (CountryEnum.CHINA.name().equals(countTry)) {
                            excludeFields.add(field.getName());
                        }
                        break;
                    default:
                        if (!countryEnum.name().equals(countTry)) {
                            excludeFields.add(field.getName());
                        }
                        break;
                }

                CountryEnum[] countryEnums = exportControl.exportCountrys();

                List<CountryEnum> collect = Arrays.stream(countryEnums).collect(Collectors.toList());

                if (!collect.contains(CountryEnum.ALL)) {
                    long count = collect.stream().filter(x -> x.name().equals(countTry)).count();
                    if (count == 0) {
                        excludeFields.add(field.getName());
                    }
                }
            }

//            if (exportControl != null && !exportControl.export()) {
//                excludeFields.add(field.getName());
//                continue;
//            }

//            // 检查条件表达式
//            if (exportControl != null && !exportControl.condition().isEmpty()) {
//                boolean shouldExport = evaluateExportCondition(field, exportControl.condition(), data);
//                if (!shouldExport) {
//                    excludeFields.add(field.getName());
//                }
//            }
        }

        return excludeFields;
    }

//    /**
//     * 评估导出条件
//     */
//    private static boolean evaluateExportCondition(Field field, String condition, List<?> data) {
//        if (data.isEmpty()) {
//            return true;
//        }
//
//        try {
//            // 简单条件判断：如果所有数据都为null，则不导出
//            for (Object item : data) {
//                Object value = field.get(item);
//                if (value != null) {
//                    // 只要有一个非null值，就导出
//                    return true;
//                }
//            }
//            return false;
//        } catch (Exception e) {
//            return true;
//        }
//    }
}
