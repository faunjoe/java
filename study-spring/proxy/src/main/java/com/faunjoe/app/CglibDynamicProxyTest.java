package com.faunjoe.app;


import com.faunjoe.app.entity.ChromeBrowser;
import com.faunjoe.app.proxy.CglibBrowserProxy;

/**
 * cglib动态代理
 *
 * @author faunjoe
 */
public class CglibDynamicProxyTest {

    public static void main(String[] args) {
        // 直接使用ChromeBrowser对象。这样的方式就可以代理ChromeBrowser中未在Chrome接口中的方法。
        ChromeBrowser browser = CglibBrowserProxy.getInstance().getProxy(ChromeBrowser.class);
        browser.visitInternet();
        browser.listenToMusic();
    }
}
