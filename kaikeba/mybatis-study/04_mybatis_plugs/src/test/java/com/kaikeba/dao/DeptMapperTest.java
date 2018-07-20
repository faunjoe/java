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
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/19 11:44
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
    public void test01() {
        DeptMapper dao = session.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDname("金融事业部3");
        dept.setLoc("北京");
        dept.setFlag(false);// 表中与之对应数据行flag字段0
        dao.deptSave(dept);
        session.commit();
    }

    @Test
    public void test02() {
        DeptMapper dao = session.getMapper(DeptMapper.class);
        List<Dept> deptList = dao.deptFind();
        deptList.forEach(System.out::println);
    }

    @After
    public void end() {
        if (session != null) {
            session.close();
        }
    }
}