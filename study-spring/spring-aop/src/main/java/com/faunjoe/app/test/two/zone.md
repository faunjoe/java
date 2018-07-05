2.XML配置(ProxyFactoryBean)
在写AOP概念的时候，看Spring的官方文档中对其AOP的定位不是要做最强大的AOP实现，而是通过与IOC容器的结合从而达到便捷的使用。ProxyFactoryBean实现了FactoryBean接口(关于FactoryBean见FactoryBean)，从而完美地结合了AOP与IOC。

来看简单的例子

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:aop="http://www.springframework.org/schema/aop"
	xsi:schemaLocation="
	http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
	http://www.springframework.org/schema/aop
	http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">
	
	<!-- 原始对象 -->
	<bean id="chromeBrowser" class="com.lcifn.spring.aop.bean.ChromeBrowser"/>
	<!-- 环绕增强对象 -->
	<bean id="browserAroundAdvice" class="com.lcifn.spring.aop.advice.BrowserAroundAdvice"></bean>
	
	<bean id="browserProxy" class="org.springframework.aop.framework.ProxyFactoryBean">
		<!-- 接口 -->
		<property name="interfaces" value="com.lcifn.spring.aop.bean.Browser"/>
		<!-- 要代理的对象 -->
		<property name="target" ref="chromeBrowser"/>
		<!-- 拦截器组 -->
		<property name="interceptorNames">
			<list>
				<value>browserAroundAdvice</value>
			</list>
		</property>
	</bean>
</beans>
ProxyFactoryBean相当于ProxyFactory实现了FactoryBean接口，通过IOC动态地创建代理对象。主要配置的属性有：

interfaces:代理对象要实现的接口集合，其实也就是原始对象实现的接口集合。所以也可以省略掉，因为Spring会通过原始对象获取其所有的接口。
target:原始对象，即要被代理的对象
interceptorNames:拦截器名称集合，可以是Advice(增强)或Advisor(切面)的实现类，而最终形成拦截器链时都转化成Advisor。
测试类如下：

public class ProxyFactoryBeanTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop/proxyfactorybean.xml");
		Browser browser = (Browser) context.getBean("browserProxy");
		browser.visitInternet();
	}
}
可以发现以上所有的代理都是通过接口的方式来接收，也就是说，底层是通过JDK自带的Proxy生成的代理。但是它的代理只能基于接口，如果想对未在接口中定义的方法或者类本身就没有实现接口的方法进行代理，那就要使用CGLIB的方式了。

在ChromeBrowser中增加一个非接口定义的方法

public String seeMovie(String movie){
	System.out.println("see a movie:" + movie);
	return movie + " has bean seen";
}
通过正则表达式去匹配此方法进行代理，XML配置如下

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:aop="http://www.springframework.org/schema/aop"
	xsi:schemaLocation="
	http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
	http://www.springframework.org/schema/aop
	http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">
	
	<!-- 原始对象 -->
	<bean id="chromeBrowser" class="com.lcifn.spring.aop.bean.ChromeBrowser"/>
	<!-- 环绕增强对象 -->
	<bean id="browserAroundAdvice" class="com.lcifn.spring.aop.advice.BrowserAroundAdvice"></bean>
	<!-- 切面 -->
	<bean id="regexpAdvisor" class="org.springframework.aop.support.RegexpMethodPointcutAdvisor">
		<property name="advice" ref="browserAroundAdvice"></property>
		<!-- 切入点正则表达式 -->
		<property name="pattern" value="com.lcifn.spring.aop.bean.ChromeBrowser.seeMovie"></property>
	</bean>
	
	<bean id="browserProxy" class="org.springframework.aop.framework.ProxyFactoryBean">
		<!-- 要代理的对象 -->
		<property name="target" ref="chromeBrowser"/>
		<!-- 拦截器组 -->
		<property name="interceptorNames" value="regexpAdvisor"/>
		<!-- proxyTargetClass -->
		<property name="proxyTargetClass" value="true"></property>
	</bean>
</beans>
对ProxyFactoryBean的配置新增proxyTargetClass属性，网上对此属性的解释是强制使用CGLIB代理对象，而在Spring的文档中对此的解释则是

force proxying for the TargetSource's exposed target class. If that target class is an interface, a JDK proxy will be created for the given interface. If that target class is any other class, a CGLIB proxy will be created for the given class.

即强制暴露TargetSource中的目标class，如果此class是接口，则使用JDK代理，如果是类对象，则使用CGLIB代理。但是正常情况下，都是使用CGLIB代理。

来看测试类

public class RegexpProxyFactoryBeanTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop/proxyfactorybean-regexp.xml");
		ChromeBrowser browser = (ChromeBrowser) context.getBean("browserProxy");
		browser.seeMovie("The Great Wall");
	}
}
此时已经能解决大部分的问题了，但AOP所处理的就是多个业务中相似的非逻辑相关的问题。因而ProxyFactoryBean的配置会有很多，太多的XML配置总会很麻烦。Spring设计时也考虑到这个问题，因而有了自动代理。