4.Spring+AspectJ+注解
Spring3.0的发布通过配置类让XML配置可以完美地被取代，而AOP的配置也可以通过注解的方式更加便捷的设置。下面还以浏览器举例，来看注解的AOP如何配置。

@Component
[@Aspect](https://my.oschina.net/aspect)
public class AspectJAnnotationBrowserAroundAdvice {
	@Pointcut("execution(* com.lcifn.spring.aop.bean.ChromeBrowser.*(..))")
	private void pointcut(){
		
	}
	
	@Around(value="pointcut()")
	public Object aroundIntercept(ProceedingJoinPoint pjp) throws Throwable{
		encrypt();
		Object retVal = pjp.proceed();
		decrypt();
		return retVal;
	}
	
	// 加密
	private void encrypt(){
		System.out.println("encrypt ...");
	}
	
	// 解密
	private void decrypt(){
		System.out.println("decrypt ...");
	}
}
@Aspect作用在类上，标识这是一个切面类。
@Pointcut一般标识在一个空方法上，值为aspectj的连接点表达式。关于连接点表达式这里就不详述了。
@Around标识此方法为环绕增强，值为@Pointcut标识的方法名，或者直接使用连接点表达式也可。
比如

@Around("execution(* com.lcifn.spring.aop.bean.ChromeBrowser.*(..))")
类上的@Component注解表示它被Spring所管理。当然要使这些注解生效，也需要启用相关配置，来看配置类。

@Configuration
@ComponentScan("com.lcifn.spring.aop.bean,com.lcifn.spring.aop.advice")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AppConfig {

}
@Configuration标识这是Spring的配置类
@ComponentScan则是注解方式的类扫描，值为要扫描的包路径
@EnableAspectJAutoProxy表示使用AspectJ注解，proxyTargetClass=true标识启用CGLIB代理
没有了XML配置，启动Spring容器当然不能再用ClassPathXmlApplicationContext类，而是使用AnnotationConfigApplicationContext。在创建对象时传入配置类的Class对象作为参数。

public class AspectJAnnotationAopTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ChromeBrowser browser = (ChromeBrowser) context.getBean("chromeBrowser");
		browser.visitInternet();
		browser.listenToMusic();
		browser.seeMovie("The Great Wall");
	}
}
有人可能觉得因为历史的缘故或其他原因，不想使用AspectJ注解配置AOP，而是通过XML配置，可不可以呢？Spring也考虑到此种情况了。

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
	<bean id="aspectjBrowserAroundAdvice" class="com.lcifn.spring.aop.advice.AspectJBrowserAroundAdvice"></bean>
	
	<!-- aspectj aop 配置 -->
	<aop:config>
		<!-- 切入点配置 -->
		<aop:pointcut id="browserPointcut" expression="execution(* com.lcifn.spring.aop.bean.*.*(..))"/>
		<aop:aspect ref="aspectjBrowserAroundAdvice">
			<!-- 环绕增强 -->
			<aop:around method="aroundIntercept" pointcut-ref="browserPointcut" />
		</aop:aspect>
	</aop:config>
</beans>
通过aop:config标签及其子标签配置，其中aop:pointcut切入点的配置可以和aop:aspect同级，这样可以被多个aspect重复使用，也可以配置再aop:aspect内部，只被单个aspect使用。

如果存在外部的advice配置，比如事务管理的tx:advice，则可以通过aop:advisor进行整合。这里也不详细介绍了。

上面介绍了纯注解和纯XML两种方式，但实际项目中往往是简单的XML+注解的方式。AOP的配置使用注解，同纯注解中的AspectJAnnotationBrowserAroundAdvice类一致，而不使用配置类，启用XML配置的方式。

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xsi:schemaLocation="
	http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
	http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-3.0.xsd
	http://www.springframework.org/schema/aop
	http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">
	<!-- 类扫描 -->
	<context:component-scan base-package="com.lcifn.spring.aop.bean,com.lcifn.spring.aop.advice"/>
	<!-- 启用AspectJ注解 -->
	<aop:aspectj-autoproxy/>
</beans>
可以发现此时的XML配置变得特别的简单且能兼容历史，而注解使用也是便捷，因而很多人喜欢采用此种方式也就可以理解。

对于Spring AOP的增强，本文都是采用AroundAdvice环绕增强来举例，对于其他的增强以他人的一个表格简单总结下。而对于引入增强(IntroductionAdvice)后续会有单独的章节介绍。

增强类型	基于 AOP 接口	基于 @Aspect	基于 aop:config
Before Advice（前置增强）	MethodBeforeAdvice	@Before	aop:before
AfterReturningAdvice（后置增强）	AfterReturningAdvice	@AfterReturning	aop:after-returning
AfterAdvice(Finally增强)	无	@After	aop:after
AroundAdvice（环绕增强）	MethodInterceptor	@Around	aop:around
ThrowsAdvice（抛出增强）	ThrowsAdvice	@AfterThrowing	aop:after-throwing
IntroductionAdvice（引入增强）	DelegatingIntroductionInterceptor	@DeclareParents	aop:declare-parents
本文介绍了Spring AOP的各种实现，从ProxyFactory, 到ProxyFactoryBean，再到自动代理DefaultAdvisorAutoProxyCreator，最后到与AspectJ的结合。现在可能很少人会使用前三种方式来配置AOP，但了解这些实现能够帮助我们更好地理解Spring AOP的实现原理和架构设计。**我们研究一个框架的使用，实现乃至于源码，更多地应该理解它的整体架构以及设计理念，尤其是一个设计优秀的框架。**希望通过对优秀的框架地学习，来提升自己的编码水平甚至软件架构水平。后面的章节会深入Spring AOP的源码，希望通过对它的学习能够进一步地提升自己，也希望看文章的同学们也能够同我一起加油！

参考文档：

1.https://my.oschina.net/huangyong/blog/161402