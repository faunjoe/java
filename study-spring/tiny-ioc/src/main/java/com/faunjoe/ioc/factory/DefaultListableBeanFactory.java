package com.faunjoe.ioc.factory;

import com.faunjoe.ioc.beans.BeanDefinition;
import com.faunjoe.ioc.beans.BeanDefinitionRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DefaultListableBeanFactory
 * @author faunjoe
 */
public class DefaultListableBeanFactory extends AbstractBeanFactory implements ConfigurableListableBeanFactory, BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
    private List<String> beanDefinitionNames = new ArrayList<String>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
        beanDefinitionNames.add(beanName);
    }

    @Override
    public void preInstantiateSingletons() throws Exception {
        for (String beanName : beanDefinitionNames) {
            getBean(beanName);
        }
    }

    public <T> List<T> getBeansForType(Class<T> type) throws Exception {
        List<T> list = new ArrayList<T>();
        for (String beanName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            Class typeToMatch = beanDefinition.getBeanClass();
            if (typeToMatch == null) {
                if (beanDefinition.getBeanClassName() != null) {
                    typeToMatch = Class.forName(beanDefinition.getBeanClassName());
                } else {
                    throw new RuntimeException("bean name for " + beanDefinition.getBeanName() + " not define bean class");
                }
            }
            if (type.isAssignableFrom(typeToMatch)) {
                list.add((T) getBean(beanName));
            }
        }
        return list;
    }

    @Override
    protected BeanDefinition getBeanDefinitionByName(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

}
