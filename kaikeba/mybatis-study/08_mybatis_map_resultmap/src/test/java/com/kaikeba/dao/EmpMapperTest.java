package com.kaikeba.dao;

import com.kaikeba.beans.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/19 15:12
 */
public class EmpMapperTest {

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
    public void test01() {
        EmpMapper dao = session.getMapper(EmpMapper.class);
        List<Employee> list = dao.empFind();
        list.forEach(System.out::println);
    }


    @After
    public void end() {
        if (session != null) {
            session.close();
        }
    }
}