package com.faunjoe.app;


import com.faunjoe.app.entity.Browser;
import com.faunjoe.app.entity.ChromeBrowser;
import com.faunjoe.app.proxy.JdkBrowserProxy;

/**
 * jdk动态代理
 *
 * @author faunjoe
 */
public class JdkDynamicProxyTest {

    public static void main(String[] args) {
        // JDK动态代理的代理对象只能通过接口去接收，如果用原对象接收，会报类型转换异常。
        Browser browser = (Browser) new JdkBrowserProxy(new ChromeBrowser()).getProxy();
        //ChromeBrowser browser = (ChromeBrowser) new JdkBrowserProxy(new ChromeBrowser()).getProxy();
        browser.visitInternet();
    }
}
