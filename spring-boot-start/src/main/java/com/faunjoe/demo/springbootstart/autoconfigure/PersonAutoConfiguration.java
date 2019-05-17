package com.faunjoe.demo.springbootstart.autoconfigure;

import com.faunjoe.demo.springbootstart.domain.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-11-27 14:41
 */
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "person", name = "enabled", havingValue = "true", matchIfMissing = true)
public class PersonAutoConfiguration {

    @ConfigurationProperties(prefix = "person")
    @Bean
    public Person person() {
        return new Person();
    }
}
