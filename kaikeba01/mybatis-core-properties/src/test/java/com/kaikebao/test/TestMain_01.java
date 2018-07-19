package com.kaikebao.test;

import com.kaikeba.beans.Dept;
import com.kaikeba.dao.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/17 11:38
 */
public class TestMain_01 {

    private SqlSession session;

    @Before
    public void start() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("myBatis-config.xml");
            //InputStream propertiesStream = Resources.getResourceAsStream("config2.properties");
            //Properties properties = new Properties();
            //properties.load(propertiesStream);
            //SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream, null, properties);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream, "development2");
            session = factory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveDept(){
        Dept dept = new Dept();
        dept.setDname("风控部2");
        dept.setLoc("北京");

        try{
            session.insert("com.kaikeba.dao.DeptMapper.saveDept", dept);
            session.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeptFindById(){
        try {
            Dept dept = session.selectOne("com.kaikeba.dao.DeptMapper.deptFindById", 51);
            System.out.println(dept.getDname());
        } catch (Exception e) {
             e.printStackTrace();
        }
    }

    @Test
    public void testDeptFindById1(){
        try {
            DeptMapper mapper = session.getMapper(DeptMapper.class);
            Dept dept = mapper.deptFindById(51);
            System.out.println(dept.getDname());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @After
    public void end(){
        if(session!=null){
            session.close();
        }
    }
}
