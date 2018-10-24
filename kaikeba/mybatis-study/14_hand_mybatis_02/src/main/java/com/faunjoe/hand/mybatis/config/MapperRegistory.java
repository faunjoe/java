package com.faunjoe.hand.mybatis.config;

import com.faunjoe.hand.mybatis.beans.Dept;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapperRegistory {

    public static final Map<String, MapperData> methodSqlMapping = new ConcurrentHashMap<String, MapperData>();

    // 使用
    // 1. 在这里配置
    // 2. Java Bean的属性名字要和数据库表的名字一致
    public MapperRegistory() {
        methodSqlMapping.put("com.faunjoe.hand.mybatis.config.mappers.DeptMapper.selectByPrimaryKey",
                new MapperData("select * from dept2 where deptno = %d", Dept.class));
    }

    public class MapperData<T> {
        private String sql;
        private Class<T> type;

        public MapperData(String sql, Class<T> type) {
            this.sql = sql;
            this.type = type;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }

        public Class<T> getType() {
            return type;
        }

        public void setType(Class<T> type) {
            this.type = type;
        }
    }

    public MapperData get(String nameSpace) {
        return methodSqlMapping.get(nameSpace);
    }
}
