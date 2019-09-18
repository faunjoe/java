package com.faunjoe.solution.java.htmlutil;

import org.junit.Test;
import org.springframework.web.util.HtmlUtils;

/**
 * @author faunjoe
 * @version 创建时间：2019-07-10 17:12
 */
public class HtmlHelper {

    @Test
    public void htmlUnescape(){
        String str = "&lt;p&gt;请在输入框内贴入你需要转换的HTML代码&lt;/p&gt; &lt;p&gt;HTML转换工具，可以将HTML代码转换为HTML转义字符串&lt;/p&gt; &lt;p&gt;直接将你所要用程序输出的大串HTML代码贴到输入框中，即可一键生成&lt;/p&gt; &lt;p&gt;如果您觉得好用，请记得收藏我们的地址！&lt;/p&gt;";
        String s = HtmlUtils.htmlUnescape(str);
        s = HtmlUtils.htmlUnescape(s);
        System.out.println(s);
    }
}
