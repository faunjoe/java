package com.atguigu.spring.tx.xml.service;

import java.util.List;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/27 14:35
 */
public interface Cashier {

    public void checkout(String username, List<String> isbns);

}
