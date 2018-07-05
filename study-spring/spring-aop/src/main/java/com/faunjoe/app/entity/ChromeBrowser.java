package com.faunjoe.app.entity;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/8 14:15
 */
@Component
public class ChromeBrowser implements Browser {
    @Override
    public void visitInternet() {
        System.out.println("visit YouTube");
    }

    @Override
    public void listenToMusic() {
        System.out.println("listen to Cranberries");
    }

    public String seeMovie(String movie, Date date, String personName){
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println(df.format(date) + " " + personName + " see a movie:" + movie);
        return movie + " has bean seen";
    }

    public String seeMovie2(String movie, Long date, String personName){
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println(df.format(date) + " " + personName + " see a movie:" + movie);
        return movie + " has bean seen";
    }
}
