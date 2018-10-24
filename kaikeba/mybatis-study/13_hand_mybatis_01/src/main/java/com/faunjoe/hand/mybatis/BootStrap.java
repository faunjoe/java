package com.faunjoe.hand.mybatis;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 00:29
 */
public class BootStrap {

    public static void main(String[] args){
        MySqlSession sqlSession = new MySqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.selectByPrimaryKey(10);
        System.out.println(dept);
    }
}
