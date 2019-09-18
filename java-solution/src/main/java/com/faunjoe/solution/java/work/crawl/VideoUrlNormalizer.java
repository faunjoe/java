package com.faunjoe.solution.java.work.crawl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-05 14:57
 */
public class VideoUrlNormalizer {

    public static String[] normalizeUrl(String url) {
        String furl;
        String site;

        if (url.contains(".iqiyi.com")) {
            furl = url.replaceAll("(?<=\\.html)[#\\?].+$", "");
            site = "iqiyi";
        } else if (url.contains(".qq.com")) {
            furl = url.replaceAll("(?<=\\.html)[#\\?].+$", "");
            site = "qq";
        } else if (url.contains(".youku.com")) {
            furl = url.replaceAll("(?<=\\.html)[#\\?].+$", "");
            site = "youku";
        } else if (url.contains(".tudou.com")) {
            furl = url.replaceAll("(?<=\\.html)[#\\?].+$", "");
            site = "tudou";
        } else if (url.contains("maoyan.meituan.net")) {
            furl = "";
            site = "maoyan";
        } else {
            throw new RuntimeException("unknown url: " + url);
        }
        return new String[]{furl, site};
    }

    public static String extractUid1(String profileUrl) {
        if (profileUrl == null) return null;
        String temp = profileUrl.replaceAll("https?://weibo\\.com/u/", "");
        temp = temp.replaceAll("https?://weibo\\.com/", "");
        temp = temp.replaceFirst("\\?[^/]+", "");
        return temp;
    }

    public static String extractBid(String url) {
        Pattern p = Pattern.compile("/(\\w+)$");
        Matcher m = p.matcher(url);

        String bid;
        if (m.find()) {
            bid = m.group(1);
        } else {
            bid = url;
        }
        return bid;
    }

    public static String getMd5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            // 32位加密
            return buf.toString();
            // 16位的加密
            // return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String url = "http://www.iqiyi.com/w_19ru11j8gt.html";
        System.out.println(getMd5(url));

        System.out.println(extractBid(url));
    }

}
