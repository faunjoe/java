package com.atguigu.spring.tx.xml.service.impl;

import com.atguigu.spring.tx.xml.service.BookShopService;
import com.atguigu.spring.tx.xml.service.Cashier;

import java.util.List;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/27 14:37
 */
public class CashierImpl implements Cashier {

    private BookShopService bookShopService;

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkout(String username, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(username, isbn);
        }
    }

}
