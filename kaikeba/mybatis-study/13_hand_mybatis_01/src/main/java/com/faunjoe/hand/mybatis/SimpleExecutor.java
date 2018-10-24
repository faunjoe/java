package com.faunjoe.hand.mybatis;

import java.sql.*;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 00:10
 */
public class SimpleExecutor implements Executor {
    public <E> E query(String sql, Object parameter) {
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt;
            pstmt = conn.prepareStatement(String.format(sql, Integer.parseInt(String.valueOf(parameter))));
            ResultSet rs = pstmt.executeQuery();
            Dept dept = new Dept();
            while (rs.next()) {
                dept.setDeptNo(rs.getInt(1));
                dept.setDname(rs.getString(2));
                dept.setLoc(rs.getString(3));
            }
            return (E) dept;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/kaikeba?characterEncoding=utf-8";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, "root", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
