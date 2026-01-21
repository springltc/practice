package com.example.coding.spring.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateAwareExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Objects;

public class AspectUtil {

    private static final TemplateAwareExpressionParser parser = new SpelExpressionParser();

    private AspectUtil() {
    }

    public static String getMarkerValue(JoinPoint point, String marker) {
        if (StringUtils.isBlank(marker)) {
            return "null";
        } else if (!marker.startsWith("#")) {
            return marker;
        }

        MethodSignature ms = (MethodSignature) point.getSignature();
        String[] names = ms.getParameterNames();
        Object[] values = point.getArgs();

        EvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < names.length; i++) {
            context.setVariable(names[i], values[i]);
        }

//        Expression expression = parser.parseExpression(marker, ParserContext.TEMPLATE_EXPRESSION);
        Expression expression = parser.parseExpression(marker, null);

        Object value = expression.getValue(context);

        return objToStr(value);

    }

    public static String objToStr(Object obj) {
        return Objects.isNull(obj) ? "null" : obj.toString();
    }
}
