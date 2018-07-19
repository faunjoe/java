package com.kaikeba.typehandler.util;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/17 15:09
 */
public class MyTypeHandler implements TypeHandler {

    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null) {// dept.flag=null   insertsql  flag设置0
            ps.setInt(i, 0);
            return;
        }
        System.out.println("类型转换器开始工作");
        Boolean flag = (Boolean) parameter;
        if (flag == true) {
            ps.setInt(i, 1);
        } else {
            ps.setInt(i, 0);
        }

    }

    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        int flag = rs.getInt(columnName);
        Boolean myFlag = Boolean.FALSE;
        if (flag == 1) {
            myFlag = Boolean.TRUE;
        }
        return myFlag;
    }

    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        int flag = rs.getInt(columnIndex);
        Boolean myFlag = Boolean.FALSE;
        if (flag == 1) {
            myFlag = Boolean.TRUE;
        }
        return myFlag;
    }

    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int flag = cs.getInt(columnIndex);
        Boolean myFlag = Boolean.FALSE;
        if (flag == 1) {
            myFlag = Boolean.TRUE;
        }
        return myFlag;
    }

}