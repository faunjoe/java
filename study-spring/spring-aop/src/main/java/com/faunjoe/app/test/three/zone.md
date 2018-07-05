3.自动代理(DefaultAdvisorAutoProxyCreator)
自动代理，即自动发现Advisor(切面)配置，意味着不再需要一个个地配置ProxyFactoryBean，只需要配置特定的切面即可。来看配置：

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
		<property name="pattern" value="com.lcifn.spring.aop.bean.ChromeBrowser.visit.*"></property>
	</bean>
	
	<!-- 自动扫描切面代理类 -->
	<bean class="org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator">
		<property name="optimize" value="true"></property>
	</bean>
</beans>
此时如果增加一种AOP逻辑，只需要配置一个新的切面类，指定要代理的切入点和增强类即可。自动代理的测试同ProxyFactoryBean相同，就不展示了。

这里涉及到一个新的属性optimize，此属性在使用JDK还是CGLIB代理的判断上同proxyTargetClass一致。但其文档上阐述了一些其他信息。

Set whether proxies should perform aggressive optimizations.The exact meaning of "aggressive optimizations" will differ between proxies, but there is usually some tradeoff.

用来设置代理时是否使用激进的优化策略。但不同的代理间的优化策略也不相同，通常情况只是一种权衡。

For example, optimization will usually mean that advice changes won't take effect after a proxy has been created. For this reason, optimization is disabled by default. An optimize value of "true" may be ignored if other settings preclude optimization: for example, if "exposeProxy" is set to "true" and that's not compatible with the optimization.

比如，优化通常意味着对于已经生成的代理，增强(Advice)的变化无法对其产生影响。鉴于此，默认优化配置是禁止的。另外如果其他配置阻止了优化策略的，optimize=true将被忽略。比如exposeProxy=true与优化策略是不兼容的。

将自动代理类DefaultAdvisorAutoProxyCreator的optimize属性设置为true，是因为并不清楚代理的切面是什么情况，因而需要Spring帮助我们对各种情况做一些权衡。

做到这里，当年Spring的罗大侠觉得这下应该满足你们这群用户了吧。可是很多用户又提出新的问题：业务越来越复杂，我们需要更加精细的控制。另外JDK5的出现让人们意识到注解相比于XML更简洁。因此，罗大侠又说，ok，都满足你们，集成AspectJ，支持注解，你们满意了吧。