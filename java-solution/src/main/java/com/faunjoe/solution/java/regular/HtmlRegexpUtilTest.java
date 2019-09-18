package com.faunjoe.solution.java.regular;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author faunjoe
 * @version 创建时间：2019-05-31 17:07
 */
public class HtmlRegexpUtilTest {

    String html = "<img class=\\\"\\\" src=\\\"http://piaoshen.oss-cn-beijing.aliyuncs.com/news/images/2019/05/21/62C1521AC7CD7F88.jpg\\\"><p class=\\\"\\\"><em class=\\\"\\\"><strong class=\\\"\\\">1</strong>/6</em>123新浪娱乐讯 哈哈家族迎来重要任务——当一天乡村幼儿园老师。四弟王源“皮皮源”属性再次上线，戴上粉红小猪帽与孩子们打成一片。三个小朋友现场组成“亚丁男孩”组合，与王源开启一场男孩之间的专属“决斗”。</p><img class=\\\"\\\" src=\\\"http://piaoshen.oss-cn-beijing.aliyuncs.com/news/images/2019/05/21/B6CD8B80CF142A5A.jpg\\\"><p class=\\\"\\\"><em class=>";

    @Test
    public void testChinese(){

        String chinese = HtmlRegexpUtil.filterHtml(html);
        System.out.println(chinese);
    }

    @Test
    public void testFilterAllHtml(){
        String chinese = HtmlRegexpUtil.filterHtml(HtmlString.html);
        System.out.println(chinese);
    }

    @Test
    public void testFilterHtmlTag(){
        String str = "<a href=\"/\" class=\"logo\">\n" +
                "            <!-- mini logo for sidebar mini 50x50 pixels -->\n" +
                "            <span class=\"logo-mini\"><b>M</b></span>\n" +
                "            <!-- logo for regular state and mobile devices -->\n" +
                "            <span class=\"logo-lg\"><b>票务对账管理平台</b></span>\n" +
                "        </a>";
        String desc = HtmlRegexpUtil.fiterHtmlTag(str, "span");
        System.out.println(desc);
    }

    /**
     * 剔出<html>的标签
     */
    @Test
    public void testFilterHtml(){
        String s = html.replaceAll("</?[^>]+>", "");
        System.out.println(s);
    }

    /**
     * 剔出<html>的标签
     */
    @Test
    public void testFilterHtml2(){
        String s = html.replaceAll("<[^>]*>", "");
        System.out.println(s);
    }

    @Test
    public void testHtml1Text(){
        String htmlStr = html;
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
        String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
        String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
        System.out.println(htmlStr);
    }

    @Test
    public void testHtml2Text(){
        String htmlStr = html; // 含html标签的字符串
        String textStr = "";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;
        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            String regEx_html = "<([^>]+)>"; // 定义HTML标签的正则表达式
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签
            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签
            textStr = htmlStr;
        } catch (Exception e) {System.err.println("Html2Text: " + e.getMessage()); }
        //剔除空格行
        textStr=textStr.replaceAll("[ ]+", " ");
        textStr=textStr.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");

        // 返回文本字符串
        System.out.println(textStr);
    }

    @Test
    public void aa(){
        String ver = "1.3.0";
        List<Integer> ids = Arrays.stream(ver.split("\\."))
                .map(p -> Integer.valueOf(p))
                .collect(Collectors.toList());
        System.out.println(ids);
    }
}
