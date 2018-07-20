package com.kaikeba.dao;

import com.kaikeba.beans.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/20 11:47
 */
public class DeptMapperTest {

    private SqlSession session;

    @Before
    public void start() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("myBatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            session = factory.openSession();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Test
    public void deptFindById() {
        try {
            DeptMapper dao = session.getMapper(DeptMapper.class);
            Dept dept = dao.deptFindById(10);
            System.out.println();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @After
    public void end() {
        if (session != null) {
            session.close();
        }
    }
}