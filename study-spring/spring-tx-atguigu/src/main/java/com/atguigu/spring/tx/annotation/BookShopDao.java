package com.atguigu.spring.tx.annotation;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/27 11:46
 */
public interface BookShopDao {

    /**
     * 根据书号获取书的单价
     *
     * @param isbn
     * @return
     */
    public int findBookPriceByIsbn(String isbn);


    /**
     * 更新数的库存. 使书号对应的库存 - 1
     *
     * @param isbn
     */
    public void updateBookStock(String isbn);


    /**
     * 更新用户的账户余额: 使 username 的 balance - price
     *
     * @param username
     * @param price
     */
    public void updateUserAccount(String username, int price);
}