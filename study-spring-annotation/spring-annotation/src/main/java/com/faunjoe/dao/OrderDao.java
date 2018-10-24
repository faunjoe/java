package com.faunjoe.dao;

import org.springframework.stereotype.Repository;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 23:02
 */
@Repository
public class OrderDao {
    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "OrderDao [lable=" + lable + "]";
    }
}
