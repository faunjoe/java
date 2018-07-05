package com.faunjoe.ioc.xml;


import com.faunjoe.ioc.beans.BeanDefinition;
import com.faunjoe.ioc.beans.BeanDefinitionRegistry;
import com.faunjoe.ioc.beans.BeanReference;
import com.faunjoe.ioc.beans.PropertyValue;
import com.faunjoe.ioc.resource.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;


/**
 * 实现xml文件的BeanDefinition读取类XmlBeanDefinitionReader
 * @author faunjoe
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader{

	/**
	 * BeanDefinition注册到BeanFactory接口
	 */
    private BeanDefinitionRegistry registry;

	/**
	 * 资源载入类
	 */
    private ResourceLoader resourceLoader;
    
	public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
	    this.registry = registry;
        this.resourceLoader = resourceLoader;
	}
	
	@Override
	public void loadBeanDefinitions(String location) throws Exception{
		InputStream is = getResourceLoader().getResource(location).getInputStream();
		doLoadBeanDefinitions(is);
	}

	protected void doLoadBeanDefinitions(InputStream is) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(is);
		registerBeanDefinitions(document);
		is.close();
	}

	protected void registerBeanDefinitions(Document document) {
		Element root = document.getDocumentElement();
		parseBeanDefinitions(root);
	}

	protected void parseBeanDefinitions(Element root) {
		NodeList nodeList = root.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node item = nodeList.item(i);
			if(item instanceof Element){
				Element ele = (Element)item;
				processBeanDefinition(ele);
			}
		}
	}

	protected void processBeanDefinition(Element ele) {
		String name = ele.getAttribute("id");
		String className = ele.getAttribute("class");
		if(className==null || className.length()==0){
			throw new IllegalArgumentException("Configuration exception: <bean> element must has class attribute.");
		}
		if(name==null||name.length()==0){
			name = className;
		}
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName(className);
		processBeanProperty(ele,beanDefinition);
		getRegistry().registerBeanDefinition(name, beanDefinition);
	}

	protected void processBeanProperty(Element ele, BeanDefinition beanDefinition) {
		NodeList childs = ele.getElementsByTagName("property");
		for (int i = 0; i < childs.getLength(); i++) {
			Node node = childs.item(i);
			if(node instanceof Element){
				Element property = (Element)node;
				String name = property.getAttribute("name");
				String value = property.getAttribute("value");
				if(value!=null && value.length()>0){
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
				}else{
					String ref = property.getAttribute("ref");
					if(ref==null || ref.length()==0){
						throw new IllegalArgumentException("Configuration problem: <property> element for "+
								name+" must specify a value or ref.");
					}
					BeanReference reference = new BeanReference(ref);
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, reference));
				}
			}
		}
	}
	
	public BeanDefinitionRegistry getRegistry(){
        return registry;
    }
    
    public ResourceLoader getResourceLoader(){
        return resourceLoader;
    }
}
