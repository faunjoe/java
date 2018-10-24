package com.faunjoe.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;


public class MyTypeFilter implements TypeFilter {

    /**
     * metadataReader：读取到的当前正在扫描的类的信息
     * metadataReaderFactory:可以获取到其他任何类信息的
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
            throws IOException {
        // TODO Auto-generated method stub
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源（类的路径）
        Resource resource = metadataReader.getResource();


        // 类名称
        String className = classMetadata.getClassName();
        // 父类名称
        String superClassName = classMetadata.getSuperClassName();
        // 子类名称集合
        String[] memberClassNames = classMetadata.getMemberClassNames();
        // 接口名称集合
        String[] interfaceNames = classMetadata.getInterfaceNames();
        System.out.println("--->" + className);
        // 扫描包下所有的类，类名包含 "er"
        if (className.contains("er")) {
            return true;
        }
        return false;
    }

}