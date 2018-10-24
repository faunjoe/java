package com.faunjoe.hand.mybatis;

import com.faunjoe.hand.mybatis.beans.Dept;
import com.faunjoe.hand.mybatis.config.GpConfiguration;
import com.faunjoe.hand.mybatis.config.mappers.DeptMapper;
import com.faunjoe.hand.mybatis.executor.ExecutorFactory;
import com.faunjoe.hand.mybatis.session.GpSqlSession;


import java.io.IOException;

public class BootStrap {
    public static void main(String[] args) throws IOException {
        start();
    }

    private static void start() throws IOException {
        GpConfiguration configuration = new GpConfiguration();
        configuration.setScanPath("com.faunjoe.hand.mybatis.config.mappers");
        configuration.build();
        GpSqlSession sqlSession = new GpSqlSession(configuration, ExecutorFactory.DEFAULT(configuration));
//        GpSqlSession sqlSession = new GpSqlSession(configuration,
//                ExecutorFactory.get(ExecutorFactory.ExecutorType.CACHING.name(),configuration));
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        long start = System.currentTimeMillis();
        Dept dept = deptMapper.selectByPrimaryKey(10);
        System.out.println(dept);
        System.out.println("cost:"+ (System.currentTimeMillis() -start));
//        start = System.currentTimeMillis();
//        test = testMapper.selectByPrimaryKey(1);
//        System.out.println("cost:"+ (System.currentTimeMillis() -start));
//        System.out.println(test);
    }
}