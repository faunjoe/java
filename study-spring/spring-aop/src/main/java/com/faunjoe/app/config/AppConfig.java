package com.faunjoe.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = {"com.faunjoe.app.entity", "com.faunjoe.app.advice"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
