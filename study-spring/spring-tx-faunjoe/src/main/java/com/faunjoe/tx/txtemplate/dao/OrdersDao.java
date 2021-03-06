package com.faunjoe.tx.txtemplate.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/29 15:40
 */
public class OrdersDao {

    // 注入jdbcTemplate模板对象

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 对数据操作的方法不包含业务操作

    /**
     * 小王少钱的方法
     */
    public void reduceMoney() {
        String sql = "update account set salary=salary-? where username=?";
        jdbcTemplate.update(sql, 1000, "小王");
    }

    /**
     * 小马多钱的方法
     */
    public void addMoney() {
        String sql = "update account set salary=salary+? where username=?";
        jdbcTemplate.update(sql, 1000, "小马");
    }
}
