package com.kaikeba;

import com.kaikeba.impl.DeptMapper;
import com.kaikeba.service.SqlSession;
import com.kaikeba.util.SqlSessionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/19 14:19
 */
public class TestMain {

    public static void main(String[] args) throws Exception {

        Map StatementMapper = new HashMap();
        StatementMapper.put("dept.save", "insert into dept(dname,loc,flag) values('TEST','BEIJING',1)");

        SqlSession dao = SqlSessionFactory.Builder(DeptMapper.class);
        dao.save((String) StatementMapper.get("dept.save"));
    }
}
