package com.example.coding.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;

/**
 * @author liutc
 * @date 2025/12/23 10:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class NullToEmptyStringSerializer extends JsonSerializer<Object> {
    // 默认替换值（可以是空字符串，也可以指定其他默认值）
    private String defaultValue = "";

    // 是否对非 null 字符串进行 trim 处理
    private boolean trim = false;

    // 是否将空白字符串也视为 null 处理
    private boolean treatBlankAsNull = false;

    public NullToEmptyStringSerializer() {
    }

    public NullToEmptyStringSerializer(String defaultValue) {
        this.defaultValue = defaultValue != null ? defaultValue : "";
    }

    public NullToEmptyStringSerializer(String defaultValue, boolean trim) {
        this.defaultValue = defaultValue != null ? defaultValue : "";
        this.trim = trim;
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        String stringValue = null;

        if (value == null) {
            stringValue = defaultValue;
        } else if (value instanceof String) {
            stringValue = (String) value;

            // 检查是否是空白字符串且需要视为 null
            if (treatBlankAsNull && isBlank(stringValue)) {
                stringValue = defaultValue;
            } else if (trim) {
                stringValue = stringValue.trim();
            }
        } else if (value instanceof CharSequence) {
            stringValue = value.toString();
            if (treatBlankAsNull && isBlank(stringValue)) {
                stringValue = defaultValue;
            } else if (trim) {
                stringValue = stringValue.trim();
            }
        } else {
            // 其他类型转换为字符串
            stringValue = value.toString();
            if (trim) {
                stringValue = stringValue.trim();
            }
        }

        gen.writeString(stringValue);
    }

    /**
     * 检查字符串是否为空白（null、空字符串或只有空白字符）
     */
    private boolean isBlank(CharSequence str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
