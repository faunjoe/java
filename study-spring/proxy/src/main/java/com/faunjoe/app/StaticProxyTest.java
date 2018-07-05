package com.faunjoe.app;


import com.faunjoe.app.entity.Browser;
import com.faunjoe.app.entity.ChromeBrowser;
import com.faunjoe.app.proxy.ChromeBrowserProxy;

/**
 * 静态代理测试
 *
 * @author faunjoe
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        Browser browser = new ChromeBrowserProxy(new ChromeBrowser());
        browser.visitInternet();
    }
}
