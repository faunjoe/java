package com.faunjoe.solution.java.tool.lombok.log;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-02 11:54
 */
public class SomeService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SomeService.class);

    public static void main(String[] args){
        log.debug("doing stuff ...");
    }
}
