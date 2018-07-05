package com.faunjoe.app;


import com.faunjoe.app.entity.Browser;
import com.faunjoe.app.entity.ChromeBrowser;
import com.faunjoe.app.entity.Game;
import com.faunjoe.app.proxy.CglibIntroductionBrowserProxy;

/**
 *
 */
public class CglibIntroductionDynamicProxyTest {

	public static void main(String[] args) {
		Browser browser = CglibIntroductionBrowserProxy.getInstance().getProxy(ChromeBrowser.class);
		browser.visitInternet();
		
		Game game = (Game) browser;
		game.start();
	}
}
