package com.faunjoe.config;

import com.faunjoe.beans.Blue;
import com.faunjoe.beans.Car;
import com.faunjoe.beans.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/23 16:59
 */

@Configuration
public class MainConfigBeanPostProcessor {

    @Bean(initMethod = "init", destroyMethod = "detory")
    public Car car() {
        return new Car();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }

    @Bean
    public Blue blue(){
        return new Blue();
    }

//    Constructor Car()
//    postProcessBeforeInitialization...car=>Car{name='null', brand='null', price=null}
//    car ... init...
//    postProcessAfterInitialization...car=>Car{name='null', brand='null', price=null}null

    // 小结
    // postProcessBeforeInitialization (实例化、依赖注入完毕，在调用显示的初始化之前完成一些定制的初始化任务)
    // postProcessAfterInitialization (实例化、依赖注入完毕，在调用显示的初始化完毕时执行 )
}
