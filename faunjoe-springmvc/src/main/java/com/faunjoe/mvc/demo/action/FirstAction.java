package com.faunjoe.mvc.demo.action;


import com.faunjoe.mvc.demo.service.INamedService;
import com.faunjoe.mvc.demo.service.IService;
import com.faunjoe.mvc.framework.annotation.FAutowired;
import com.faunjoe.mvc.framework.annotation.FController;
import com.faunjoe.mvc.framework.annotation.FRequestMapping;
import com.faunjoe.mvc.framework.annotation.FRequestParam;
import com.faunjoe.mvc.framework.servlet.FModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@FController
@FRequestMapping("/web")
public class FirstAction {

    @FAutowired
    private IService service;

    @FAutowired("myName")
    private INamedService namedService;


    @FRequestMapping("/query/.*.json")
    public FModelAndView query(HttpServletRequest request, HttpServletResponse response,
                               @FRequestParam(value = "name", required = false) String name,
                               @FRequestParam("addr") String addr) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", name);
        model.put("addr", addr);
        return new FModelAndView("first.pgml", model);
    }


    @FRequestMapping("/add.json")
    public FModelAndView add(HttpServletRequest request, HttpServletResponse response) {
        out(response, "this is json string");
        return null;
    }


    public void out(HttpServletResponse response, String str) {
        try {
            response.getWriter().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
