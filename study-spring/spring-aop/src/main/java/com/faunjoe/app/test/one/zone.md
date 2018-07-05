1.硬编码(ProxyFactory)


以之前的浏览器举例，有一个Browser接口

public interface Browser {

	void visitInternet();
	
}
它的实现ChromeBrowser

public class ChromeBrowser implements Browser{

	public void visitInternet() {
		System.out.println("visit YouTube");
	}
	
}
众所周知，为了更自由的上网，需要一个境外服务器作为中转，这里就通过加密(encrypt)和解密(decrypt)两个方法模拟visitInternet方法执行前后的额外动作。

// 加密
private void encrypt(){
	System.out.println("encrypt ...");
}

// 解密
private void decrypt(){
	System.out.println("decrypt ...");
}
而真正访问时通过一个代理类来操作，使用Spring AOP最原始也是最底层的方式ProxyFactory来实现。另外还需要封装上面两个方法的增强类，分别实现Spring定义的MethodBeforeAdvice和AfterReturningAdvice两个Advice增强接口。

public class BrowserBeforeAdvice implements MethodBeforeAdvice{

	public void before(Method method, Object[] args, Object target) throws Throwable {
		encrypt();
	}
	
	//加密
	private void encrypt(){
		System.out.println("encrypt ...");
	}

}

public class BrowserAfterReturningAdvice implements AfterReturningAdvice{

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		decrypt();
	}

	//解密
	private void decrypt(){
		System.out.println("decrypt ...");
	}

}
我们使用硬编码的方式来实现代理

public class ProxyFactoryTest {

	public static void main(String[] args) {
		// 1.创建代理工厂
		ProxyFactory factory = new ProxyFactory();
		// 2.设置目标对象
		factory.setTarget(new ChromeBrowser());
		// 3.设置代理实现接口
		factory.setInterfaces(new Class[]{Browser.class});
		// 4.添加前置增强
		factory.addAdvice(new BrowserBeforeAdvice());
		// 5.添加后置增强
		factory.addAdvice(new BrowserAfterReturningAdvice());
		// 6.获取代理对象
		Browser browser = (Browser) factory.getProxy();
		
		browser.visitInternet();
	}
}

以上的前置增强和后置增强可以通过环绕增强统一处理，不过需要实现org.aopalliance.intercept.MethodInterceptor,它并不是Spring定义的接口，而是来自AOP联盟提供的API。

public class BrowserAroundAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		encrypt();
		Object retVal = invocation.proceed();
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
上面的

// 3.添加前置增强
factory.addAdvice(new BrowserBeforeAdvice());
// 4.添加后置增强
factory.addAdvice(new BrowserAfterReturningAdvice());
可以改为

// 添加环绕增强
factory.addAdvice(new BrowserAroundAdvice());
另外在上面的测试类中，并没有增强(Advice)类的作用范围，也就是说只要Browser接口中的方法都会被代理。如果在Browser接口中增加一个听音乐的方法。

public interface Browser {

	void visitInternet();
	
	void listenToMusic();
	
}

public class ChromeBrowser implements Browser{

	public void visitInternet() {
		System.out.println("visit YouTube");
	}
	
	public void listenToMusic(){
		System.out.println("listen to Cranberries");
	}
	
}
而我只想对visitInternet进行代理，可以通过正则表达式的切面类RegexpMethodPointcutAdvisor来设置，其内部使用的Pointcut类为JdkRegexpMethodPointcut。

// 创建正则表达式切面类
RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
// 添加环绕增强
advisor.setAdvice(new BrowserAroundAdvice());
// 设置切入点正则表达式
advisor.setPattern("com.lcifn.spring.aop.bean.ChromeBrowser.visitInternet");
完整的测试类

public class RegexpProxyFactoryTest {

	public static void main(String[] args) {
		// 1.创建代理工厂
		ProxyFactory factory = new ProxyFactory();
		// 2.设置目标对象
		factory.setTarget(new ChromeBrowser());
		// 3.设置代理实现接口
		factory.setInterfaces(new Class[]{Browser.class});
		// 4.创建正则表达式切面类
		RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
		// 5.添加环绕增强
		advisor.setAdvice(new BrowserAroundAdvice());
		// 6.设置切入点正则表达式
		advisor.setPattern("com.lcifn.spring.aop.bean.ChromeBrowser.visitInternet");
		// 7.工厂增加切面
		factory.addAdvisor(advisor);
		// 8.获取代理对象
		Browser browser = (Browser) factory.getProxy();
		browser.visitInternet();
	}
}
毕竟硬编码的方式过于繁琐，也不适合项目的开发，还是配置化的方式更加便捷。
