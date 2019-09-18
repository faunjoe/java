package com.faunjoe.solution.java.regular;

import org.junit.Test;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author faunjoe
 * @version 创建时间：2019-05-15 13:25
 */
public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(sb.append(HtmlString.html));
        //<img alt="" class="i-amphtml-fill-content i-amphtml-replaced-content" decoding="async" src="https://img2018.cnblogs.com/news/24442/201905/24442-20190514220224321-55849769.png">
        sb.append(
                "<img alt=\"\" class=\"i-amphtml-fill-content i-amphtml-replaced-content\" decoding=\"async\" src=\"https://img2018.cnblogs.com/news/24442/201905/24442-20190514220224321-55849769.png\">");
        //<img alt="" class="i-amphtml-fill-content i-amphtml-replaced-content" decoding="async" src="https://img2018.cnblogs.com/news/24442/201905/24442-20190513095752487-219359333.png">
        sb.append(
                "<img alt=\"\" class=\"i-amphtml-fill-content i-amphtml-replaced-content\" decoding=\"async\" src=\"https://img2018.cnblogs.com/news/24442/201905/24442-20190513095752487-219359333.png\">");
        Set<String> imgSrcList = RegularFacade.getImgSrcList(sb.toString());
        System.out.println(imgSrcList);
    }


    /**
     * 替换图片
     * @param content
     * @return
     */
    private String replaceAllImage(String content) {
        String oldStr = "http://piaoshen.oss-cn-beijing.aliyuncs.com/news/images";
        String newStr = "https://picagent.piaoshen.com/picture/cut_picture?uri=http://piaoshen.oss-cn-beijing.aliyuncs.com/news/images";
        return content.replaceAll(oldStr, newStr);
    }

    /**
     * 替换视频
     * @param content
     * @return
     */
    private String replaceAllVideo(String content){
        String oldStr = "http://piaoshen.oss-cn-beijing.aliyuncs.com/news/videos";
        String newStr = "https://vf.piaoshen.com/news/videos";
        return content.replaceAll(oldStr, newStr);
    }

    @Test
    public void testReplaceImage() {
        String s = replaceAllImage(HtmlString.htmlImgStr);
        System.out.println(s);
    }

    @Test
    public void testReplaceVideo(){
        String s = replaceAllVideo(HtmlString.htmlVideoStr);
        System.out.println(s);
    }

    /**
     * 过滤所有标签属性
     */
    @Test
    public void testAA(){
        String testStr = "<div data-bb=\"aa\" data-id=\"aa\" class=high align=center><b><font color=#0066cc><span class=high>婚姻状况</span></font></b></div>";
        //testStr = testStr.replaceAll("<([a-zA-Z]+)[^>]*>", "<$1>");
        // id去除
        Matcher matcherId = Pattern.compile(" data-\\w*?=\"[^\"]*\"").matcher(testStr);
        testStr = matcherId.replaceAll("");
        System.out.println(testStr);
    }


}
