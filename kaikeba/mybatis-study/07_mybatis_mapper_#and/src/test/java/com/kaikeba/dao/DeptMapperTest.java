package com.kaikeba.dao;

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
 * @version 创建时间：2018/7/19 14:43
 */
public class DeptMapperTest {

    private SqlSession session;
    @Before
    public void start(){
        try{
            InputStream inputStream = Resources.getResourceAsStream("myBatis-config.xml");
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
            session=factory.openSession();
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    @Test
    public void test01(){
        DeptMapper dao=session.getMapper(DeptMapper.class);
        List list=dao.deptFind("SALES");
    }

    @Test
    public void test02(){
        try{
            DeptMapper dao=session.getMapper(DeptMapper.class);
            List list=dao.deptFind2("dept2");
            System.out.println("***************"+list.size());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    @After
    public void end(){
        if(session!=null){
            session.close();
        }
    }
}