package com.faunjoe.hand.mybatis.executor;

import com.faunjoe.hand.mybatis.config.MapperRegistory;

public interface Executor {

    <T> T query(MapperRegistory.MapperData mapperData, Object parameter) throws Exception;
}