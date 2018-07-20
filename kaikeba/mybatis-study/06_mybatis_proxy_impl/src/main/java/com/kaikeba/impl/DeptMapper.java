package com.kaikeba.impl;

import com.kaikeba.service.SqlSession;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/19 14:06
 */
public class DeptMapper implements SqlSession {

    PreparedStatement ps;

    public int save(String sql) throws SQLException {
        // JDBC主要业务 输送sql
        int num = ps.executeUpdate(sql);
        return num;
    }

}
