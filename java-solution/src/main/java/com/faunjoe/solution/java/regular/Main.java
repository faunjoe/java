package com.faunjoe.solution.java.regular;

import java.util.Set;

/**
 * @author faunjoe
 * @version 创建时间：2019-05-15 13:25
 */
public class Main {

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        sb.append(sb.append(HtmlString.html));
        //<img alt="" class="i-amphtml-fill-content i-amphtml-replaced-content" decoding="async" src="https://img2018.cnblogs.com/news/24442/201905/24442-20190514220224321-55849769.png">
        sb.append("<img alt=\"\" class=\"i-amphtml-fill-content i-amphtml-replaced-content\" decoding=\"async\" src=\"https://img2018.cnblogs.com/news/24442/201905/24442-20190514220224321-55849769.png\">");
        //<img alt="" class="i-amphtml-fill-content i-amphtml-replaced-content" decoding="async" src="https://img2018.cnblogs.com/news/24442/201905/24442-20190513095752487-219359333.png">
        sb.append("<img alt=\"\" class=\"i-amphtml-fill-content i-amphtml-replaced-content\" decoding=\"async\" src=\"https://img2018.cnblogs.com/news/24442/201905/24442-20190513095752487-219359333.png\">");
        Set<String> imgSrcList = RegularFacade.getImgSrcList(sb.toString());
        System.out.println(imgSrcList);
    }
}
