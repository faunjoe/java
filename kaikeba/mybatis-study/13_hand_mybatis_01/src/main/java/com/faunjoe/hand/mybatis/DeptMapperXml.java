package com.faunjoe.hand.mybatis;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 00:18
 */
public class DeptMapperXml {

    public static final String nameSpace = "com.faunjoe.hand.mybatis.DeptMapper";

    public static final Map<String,String> methodSqlMapping = new ConcurrentHashMap<String, String>();

    static {
        methodSqlMapping.put("selectByPrimaryKey", "select * from dept2 where deptno = %d");
    }
}
