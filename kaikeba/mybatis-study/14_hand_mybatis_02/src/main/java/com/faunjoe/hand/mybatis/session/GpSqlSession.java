package com.faunjoe.hand.mybatis.session;

import com.faunjoe.hand.mybatis.config.GpConfiguration;
import com.faunjoe.hand.mybatis.config.MapperRegistory;
import com.faunjoe.hand.mybatis.executor.Executor;
import com.faunjoe.hand.mybatis.mapper.MapperProxy;

import java.lang.reflect.Proxy;

public class GpSqlSession {

    private GpConfiguration configuration;

    private Executor executor;

    public GpConfiguration getConfiguration() {
        return configuration;
    }

    //关联起来
    public GpSqlSession(GpConfiguration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz},new MapperProxy(this,clazz));
    }

    public <T> T selectOne(MapperRegistory.MapperData mapperData, Object parameter) throws Exception {
        return executor.query(mapperData, parameter);
    }
}
