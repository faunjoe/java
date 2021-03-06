package com.faunjoe.tx.txtemplate;

import com.faunjoe.tx.txtemplate.service.OrdersService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/29 15:43
 */
public class TestService {

    @Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        OrdersService userService = (OrdersService) context
                .getBean("ordersService");
        userService.accountMoney();
    }
}
