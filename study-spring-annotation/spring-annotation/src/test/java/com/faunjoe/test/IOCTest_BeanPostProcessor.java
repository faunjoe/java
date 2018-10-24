package com.faunjoe.test;

import com.faunjoe.config.MainConfigBeanPostProcessor;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/23 17:05
 */
public class IOCTest_BeanPostProcessor {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigBeanPostProcessor.class);


        applicationContext.close();
    }
}
