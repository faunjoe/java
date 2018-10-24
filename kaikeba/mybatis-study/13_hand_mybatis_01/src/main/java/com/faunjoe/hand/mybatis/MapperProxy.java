package com.faunjoe.hand.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 00:21
 */
public class MapperProxy<T> implements InvocationHandler {

    private final MySqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(MySqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(DeptMapperXml.nameSpace)) {
            String sql = DeptMapperXml.methodSqlMapping.get(method.getName());
            System.out.println(String.format(" SQL [%s],parameter [%s] ", sql, args[0]));
            return sqlSession.selectOne(sql, String.valueOf(args[0]));
        }
        return null;
    }
}
