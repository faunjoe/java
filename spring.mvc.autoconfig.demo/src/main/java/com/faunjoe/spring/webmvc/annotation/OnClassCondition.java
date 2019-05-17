package com.faunjoe.spring.webmvc.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * 当知道的某个类存在时，满足条件
 *
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-11-26 17:02
 */
public class OnClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        boolean matched = false;

        // 获取所有的ConditionalOnClass 中的属性方法
        MultiValueMap<String, Object> allAnnotationAttributes =
                annotatedTypeMetadata.getAllAnnotationAttributes(ConditionalOnClass.class.getName());

        // 获取 value() 方法中的配置值
        List<Object> objects = allAnnotationAttributes.get("value");

        try {
            for (Object klass : objects) {
                Class<?>[] type = (Class<?>[]) klass;

                matched = true;
            }
        } catch (Exception e) {
            matched = false;
        }
        System.out.println("OnClassCondition 是否匹配：" + matched);
        return matched;
    }
}
