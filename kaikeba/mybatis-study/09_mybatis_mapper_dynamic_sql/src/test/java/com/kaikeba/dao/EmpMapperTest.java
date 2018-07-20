package com.kaikeba.dao;

import com.kaikeba.beans.Dept;
import com.kaikeba.beans.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/19 15:33
 */
public class EmpMapperTest {

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
    public void dept_1(){
        DeptMapper dao=  session.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDeptNo(20);
        dept.setDname("SE");
        List list=dao.dept_1(dept);
        System.out.println(list.size());
    }

    @Test
    public void empFind(){
        try{
            EmpMapper dao=  session.getMapper(EmpMapper.class);
            Employee employee = new Employee();
            employee.setSal(1000.0);
            List list=dao.empFind(employee);
            System.out.println(list.size());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void dept_2(){
        DeptMapper dao=  session.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDname("ES");
        List list=dao.dept_2(dept);
        System.out.println(list.size());
    }

    @Test
    public void deptUpdate(){
        DeptMapper dao=  session.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDeptNo(20);
        dept.setDname("新部门");
        dao.deptUpdate(dept);

    }

    @Test
    public void dept_3(){
        DeptMapper dao=  session.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDname("ACCOUNTING");
        dept.setLoc("BeiJing");
        List list=dao.dept_3(dept);
        System.out.println(list.size());
    }

    @Test
    public void deptSave(){
        DeptMapper dao=  session.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDname("开发一部");
        dept.setLoc("北京");

        Dept dept2 = new Dept();
        dept2.setDname("开发er部");
        dept2.setLoc("北京");

        List<Dept> deptList = new ArrayList<Dept>();
        deptList.add(dept);
        deptList.add(dept2);
        dao.deptSave(deptList);
        session.commit();

    }


    @Test
    public void deptFindByList(){
        try{
            DeptMapper dao=  session.getMapper(DeptMapper.class);
            List list = new ArrayList();
            list.add(51);
            list.add(52);
            List<Dept> deptList= dao.deptFindByList(list);
            deptList.forEach(System.out::println);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void deptFindByArray(){
        try{
            DeptMapper dao=  session.getMapper(DeptMapper.class);
            int dpetArray[]=new int[2];
            dpetArray[0]=51;
            dpetArray[1]=52;
            List<Dept> deptList= dao.deptFindByArray(dpetArray);
            deptList.forEach(System.out::println);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    @Test
    public void deptFindByMap(){
        try{
            DeptMapper dao=  session.getMapper(DeptMapper.class);
            Map map = new HashMap();
            map.put("key1", 51);
            map.put("key2", 52);
            List<Dept> deptList= dao.deptFindByMap(map);
            deptList.forEach(System.out::println);
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