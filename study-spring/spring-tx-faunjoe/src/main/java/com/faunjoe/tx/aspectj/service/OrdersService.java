package com.faunjoe.tx.aspectj.service;


import com.faunjoe.tx.aspectj.dao.OrdersDao;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/29 15:53
 */
public class OrdersService {

    private OrdersDao ordersDao;

    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    // 调用dao的方法
    // 业务逻辑，写转账业务
    public void accountMoney() {
        // 小马多1000
        ordersDao.addMoney();
        // 加入出现异常如下面int i=10/0（银行中可能为突然停电等。。。）；结果：小马账户多了1000而小王账户没有少钱
        // 解决办法是出现异常后进行事务回滚
        //int i = 10 / 0;// 事务管理配置后异常已经解决
        // 小王 少1000
        ordersDao.reduceMoney();

    }
}
