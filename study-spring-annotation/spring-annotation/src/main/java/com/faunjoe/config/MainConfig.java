package com.faunjoe.config;

import com.faunjoe.beans.Car;
import com.faunjoe.beans.Person;
import com.faunjoe.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;

/**
 * 配置类 == 配置文件
 *
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 13:55
 */

@Configuration // 告诉Spring这是一个配置类
@ComponentScans(
        value = {
                @ComponentScan(value="com.faunjoe",includeFilters = {
/*						@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
						@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),*/
                        @Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
                },useDefaultFilters = false)
        }
)
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件 useDefaultFilters = false 需要设置为fasle,默认为true
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class MainConfig {

    @Bean(name = "person") //给容器中注册一个Bean;类型为返回值的类型，id 默认是用方法名作为id
    public Person person() {
        return new Person(18, "lisi");
    }

    @Bean
    public Car car01() {
        return new Car("奔驰s600", "奔驰", 5000000);
    }
}
