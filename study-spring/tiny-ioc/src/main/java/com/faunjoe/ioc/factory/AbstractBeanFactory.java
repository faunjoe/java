package com.faunjoe.ioc.factory;

import com.faunjoe.ioc.beans.BeanDefinition;
import com.faunjoe.ioc.beans.BeanReference;
import com.faunjoe.ioc.beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AbstractBeanFactory
 * @author faunjoe
 */
public abstract class AbstractBeanFactory implements ConfigurableListableBeanFactory {

	/**
	 * 单实例beanName和bean对象关系
	 */
	private Map<String, Object> singleObjects = new ConcurrentHashMap<String, Object>();
	
	@Override
    public Object getBean(String beanName){
	    Object singleBean = this.singleObjects.get(beanName);
	    if(singleBean != null){
	        return singleBean;
	    }
	    
        BeanDefinition beanDefinition  = getBeanDefinitionByName(beanName);
        if(beanDefinition==null){
            throw new RuntimeException("bean for name '"+beanName+"' not register.");
        }
        
        singleBean = doCreateBean(beanDefinition);
        this.singleObjects.put(beanName, singleBean);
        return singleBean;
    }
	
	protected Object doCreateBean(BeanDefinition beanDefinition){
		Object bean = createInstance(beanDefinition);
		applyPropertyValues(bean,beanDefinition);
		return bean;
	}

	protected Object createInstance(BeanDefinition beanDefinition) {
	    try {
    	    if(beanDefinition.getBeanClass() != null){
                return beanDefinition.getBeanClass().newInstance();
    	    }else if(beanDefinition.getBeanClassName() != null){
    	        try {
                    Class clazz = Class.forName(beanDefinition.getBeanClassName());
                    beanDefinition.setBeanClass(clazz);
                    return clazz.newInstance();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("bean Class " + beanDefinition.getBeanClassName() + " not found");
                }
    	    }
	    } catch (Exception e) {
            throw new RuntimeException("create bean " + beanDefinition.getBeanName() + " failed");
        } 
	    throw new RuntimeException("bean name for " + beanDefinition.getBeanName() + " not define bean class");
	}
	
	protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition){
	    for(PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()){
	        String name = propertyValue.getName();
	        Object value = propertyValue.getValue();
	        if(value instanceof BeanReference){
	            BeanReference reference = (BeanReference) value;
	            value = getBean(reference.getRef());
	        }
	        try {
	            Method method = bean.getClass().getDeclaredMethod("set"+name.substring(0, 1).toUpperCase()+
	                    name.substring(1), value.getClass());
	            method.setAccessible(true);
	            method.invoke(bean, value);
	        } catch(Exception e){
	            try {
                    Field field = bean.getClass().getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(bean, value);
                } catch (Exception e1) {
                    throw new RuntimeException("inject bean property " + name + " failed");
                } 
	        }
	    }
	}
	
	protected abstract BeanDefinition getBeanDefinitionByName(String beanName);

}
