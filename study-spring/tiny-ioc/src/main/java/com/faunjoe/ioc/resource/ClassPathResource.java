package com.faunjoe.ioc.resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * 实现一个ClassPathResource类可以读取classpath的文件
 * @author faunjoe
 */
public class ClassPathResource implements Resource {

    private String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : Thread.currentThread().getContextClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return classLoader.getResourceAsStream(path);
    }
}
