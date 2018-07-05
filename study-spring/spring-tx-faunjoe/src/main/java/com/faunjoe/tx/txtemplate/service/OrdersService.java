package com.faunjoe.tx.txtemplate.service;

import com.faunjoe.tx.txtemplate.dao.OrdersDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/29 15:41
 */
public class OrdersService {

    // 注入Dao层对象

    private OrdersDao ordersDao;

    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    // 注入TransactionTemplate对象

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    // 调用dao的方法
    // 业务逻辑，写转账业务

    public void accountMoney() {
        transactionTemplate.execute(new TransactionCallback<Object>() {

            @Override
            public Object doInTransaction(TransactionStatus status) {
                Object result = null;
                try {
                    // 小马多1000
                    ordersDao.addMoney();
                    // 加入出现异常如下面int
                    // i=10/0（银行中可能为突然停电等。。。）；结果：小马账户多了1000而小王账户没有少钱
                    // 解决办法是出现异常后进行事务回滚
                    int i = 10 / 0;// 事务管理配置后异常已经解决
                    // 小王 少1000
                    ordersDao.reduceMoney();
                } catch (Exception e) {
                    status.setRollbackOnly();
                    result = false;
                    System.out.println("Transfer Error!");
                }

                return result;
            }
        });
    }
}
