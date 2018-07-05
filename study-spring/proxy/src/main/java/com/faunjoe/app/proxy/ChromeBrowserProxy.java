package com.faunjoe.app.proxy;

import com.faunjoe.app.entity.Browser;
import com.faunjoe.app.entity.ChromeBrowser;

/**
 * 谷歌浏览器的代理
 *
 * @author faunjoe
 */
public class ChromeBrowserProxy implements Browser {

    private ChromeBrowser browser;

    public ChromeBrowserProxy(ChromeBrowser chromeBrowser) {
        this.browser = chromeBrowser;
    }

    @Override
    public void visitInternet() {
        encrypt();
        browser.visitInternet();
        decrypt();
    }


    // 加密
    private void encrypt() {
        System.out.println("encrypt ...");
    }

    // 解密
    private void decrypt() {
        System.out.println("decrypt ...");
    }


}
