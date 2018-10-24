package com.faunjoe;


import com.faunjoe.annotation.ZxfResource;
import com.faunjoe.beans.BeanDefine;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/23 14:27
 */
public class ClassPathXMLApplicationContext {

    Logger log = Logger.getLogger(ClassPathXMLApplicationContext.class);

    List<BeanDefine> beanList = new ArrayList<BeanDefine>();

    Map<String, Object> sigletions = new ConcurrentHashMap<String, Object>();

    public ClassPathXMLApplicationContext(String fileName) {
        this.readXML(fileName);
        this.instancesBean();
        this.propertyAnnotation();
    }

    /**
     * 读取Bean配置文件
     *
     * @param fileName
     */
    private void readXML(String fileName) {
        Document document = null;
        SAXReader saxReader = new SAXReader();

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            document = saxReader.read(classLoader.getResourceAsStream(fileName));
            Element beans = document.getRootElement();

            for (Iterator<Element> beansList = beans.elementIterator();
                 beansList.hasNext(); ) {
                Element element = beansList.next();
                BeanDefine bean = new BeanDefine(
                        element.attributeValue("id"),
                        element.attributeValue("class"));
                beanList.add(bean);
            }
        } catch (Exception e) {
            log.info("读取配置文件出错...." + e.getMessage());
        }
    }

    /**
     * 实例化Bean
     */
    private void instancesBean() {
        for (BeanDefine bean : beanList) {
            try {
                sigletions.put(bean.getId(),
                        Class.forName(bean.getClassName()).newInstance());
            } catch (Exception e) {
                log.info("实例化Bean出错..." + e.getMessage());
            }
        }
    }

    /**
     * 注解处理器
     * 如果注解ZxfResource配置了name属性，则根据name所指定的名称获取要注入的实例引用，
     * 如果注解ZxfResource;没有配置name属性，则根据属性所属类型来扫描配置文件获取要
     * 注入的实例引用
     */
    private void propertyAnnotation() {
        for (String beanName : sigletions.keySet()) {
            Object bean = sigletions.get(beanName);
            if (bean != null) {
                this.propertyAnnotation(bean);
                this.fieldAnnotation(bean);
            }
        }
    }

    /**
     * 处理在set方法加入的注解
     *
     * @param bean
     */
    private void propertyAnnotation(Object bean) {
        try {
            // 获取其属性的描述
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(bean.getClass())
                    .getPropertyDescriptors();

            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                // 获取所有set方法
                Method setter = propertyDescriptor.getWriteMethod();
                // 判断set方法是否定义了注解
                if (setter != null && setter.isAnnotationPresent(ZxfResource.class)) {
                    // 获取当前注解，并判断name属性是否为空
                    ZxfResource resource = setter.getAnnotation(ZxfResource.class);
                    String name = "";
                    Object value = null;
                    if (resource.name() != null && !"".equals(resource.name())) {
                        // 获取注解的name属性的内容
                        name = resource.name();
                        value = sigletions.get(name);
                    } else {
                        // 如果当前注解没有指定name属性，则根据类型进行匹配
                        for (String key : sigletions.keySet()) {
                            //判断当前属性所属的类型是否在配置文件中存在
                            if (propertyDescriptor.getPropertyType().isAssignableFrom(sigletions.get(key).getClass())) {
                                //获取类型匹配的实例对象
                                value = sigletions.get(key);
                                break;
                            }
                        }
                    }
                    // 允许访问private方法
                    setter.setAccessible(true);
                    // 把引用对象注入属性
                    setter.invoke(bean, value);
                }

            }
        } catch (Exception e) {
            log.info("set方法注解解析异常.........." + e.getMessage());
        }
    }

    public void fieldAnnotation(Object bean) {
        try {
            // 获取其全部的字段描述
            Field[] fields = bean.getClass().getDeclaredFields();

            for (Field f : fields) {
                if (f != null && f.isAnnotationPresent(ZxfResource.class)) {
                    ZxfResource resource = f.getAnnotation(ZxfResource.class);
                    String name = "";
                    Object value = null;
                    if (resource.name() != null && !"".equals(resource.name())) {
                        name = resource.name();
                        value = sigletions.get(name);
                    } else {
                        for (String key : sigletions.keySet()) {
                            //判断当前属性所属的类型是否在配置文件中存在
                            if (f.getType().isAssignableFrom(sigletions.get(key).getClass())) {
                                //获取类型匹配的实例对象
                                value = sigletions.get(key);
                                break;
                            }
                        }
                    }
                    //允许访问private字段
                    f.setAccessible(true);
                    //把引用对象注入属性
                    f.set(bean, value);
                }
            }
        } catch (Exception e) {
            log.info("字段注解解析异常.........." + e.getMessage());
        }
    }

    public Object getBean(String beanId) {
        return sigletions.get(beanId);
    }


}
