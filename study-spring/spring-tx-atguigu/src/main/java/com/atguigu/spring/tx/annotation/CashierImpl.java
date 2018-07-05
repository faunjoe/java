package com.atguigu.spring.tx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/27 11:58
 */

@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    @Transactional
    @Override
    public void checkout(String username, List<String> isbns) {
        for(String isbn: isbns){
            bookShopService.purchase(username, isbn);
        }
    }
}
