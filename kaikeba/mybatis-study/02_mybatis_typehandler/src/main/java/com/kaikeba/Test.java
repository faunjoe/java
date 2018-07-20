package com.kaikeba;

import com.kaikeba.beans.Dept;
import com.kaikeba.dao.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/17 15:27
 */
public class Test {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("myBatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();

        Dept dept = new Dept();
        dept.setDname("金融事业部3");
        dept.setLoc("北京");
        dept.setFlag(true);// 表中与之对应数据行flag字段0

        DeptMapper mapper = session.getMapper(DeptMapper.class);
        mapper.saveDept(dept);
        session.commit();
    }
}
