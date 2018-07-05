package com.atguigu.spring.tx.annotation;

import java.util.List;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/27 11:58
 */
public interface Cashier {

    public void checkout(String username, List<String> isbns);

}
