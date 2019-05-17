package com.faunjoe.spring.webmvc.autoconfig;

import com.faunjoe.spring.webmvc.annotation.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Web MVC 配置 Bean
 *
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-11-26 15:48
 */

@Configuration
@ComponentScan(basePackages = "com.faunjoe.spring.webmvc")
public class SpringWebMvcConfiguration {

    @ConditionalOnClass(String.class)
    @Bean("helloWorld")
    public String helloWorld() {
        return "helloWorld";
    }
}
