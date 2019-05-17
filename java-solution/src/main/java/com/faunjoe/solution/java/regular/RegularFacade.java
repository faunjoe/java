package com.faunjoe.solution.java.regular;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author faunjoe
 * @version 创建时间：2019-05-15 13:19
 */
public class RegularFacade {

    public static Set<String> getImgSrcList(String html){
        Set<String> pics = new HashSet<>();
        String img = "";
        Pattern p_image;
        Matcher m_image;
        // . 匹配除换行符 \n 之外的任何单字符
        // * 匹配前面的子表达式零次或多次
        // .* 匹配除换行符 \n 之外的任何字符
        // \s 匹配任何空白字符，包括空格、制表符、换页符等等。
        // \s* 匹配任何空白字符，包括空格、制表符、换页符
        // () 标记一个子表达式的开始和结束位置
        // ？匹配前面的子表达式零次或一次。
        // [^>] 不接受 > 字符
        //String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";

        p_image = Pattern.compile
                (regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(html);

        while (m_image.find()) {
            // 得到<img />数据
            img = m_image.group();
            // 匹配<img>中的src数据
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }
        return pics;
    }
}
