package com.faunjoe.app.entity;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

/**
 * 谷歌浏览器
 *
 * @author faunjoe
 */
@Component
public class ChromeBrowser implements Browser {


    @Override
    public void visitInternet() {
        System.out.println("visit YouTube");
    }

    public void listenToMusic() {
        System.out.println("listen to Cranberries");
    }

    public String seeMovie(String movie, Date date, String personName) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println(df.format(date) + " " + personName + " see a movie:" + movie);
        return movie + " has bean seen";
    }

    public String seeMovie2(String movie, Long date, String personName) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println(df.format(date) + " " + personName + " see a movie:" + movie);
        return movie + " has bean seen";
    }
}
