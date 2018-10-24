package com.faunjoe.rebuild;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/26 15:28
 */
public class MainTest {

    public static void main(String[] args) throws IOException {
        System.out.println("----H1型悍马----");
        System.out.println("是否需要喇叭声响？ 0-不需要  1-需要");
        String type = new BufferedReader(new InputStreamReader(System.in)).readLine();
        HummerH1 h1 = new HummerH1();
        if (type.equals("0")) {
            h1.setAlarmFlag(false);
        }
        h1.run();
    }
}
