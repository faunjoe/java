package com.faunjoe.hand.mybatis.executor;

import com.faunjoe.hand.mybatis.config.GpConfiguration;
import com.faunjoe.hand.mybatis.config.MapperRegistory;
import com.faunjoe.hand.mybatis.statement.StatementHandler;

public class SimpleExecutor implements Executor {

    private GpConfiguration configuration;

    public SimpleExecutor(GpConfiguration configuration) {
        this.configuration = configuration;
    }

    public GpConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(GpConfiguration configuration) {
        this.configuration = configuration;
    }

    public <E> E query(MapperRegistory.MapperData mapperData, Object parameter)
            throws Exception {
        //初始化StatementHandler --> ParameterHandler --> ResultSetHandler
        StatementHandler handler = new StatementHandler(configuration);
        return (E) handler.query(mapperData, parameter);
    }
}