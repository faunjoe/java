package com.faunjoe.demo.springbootstart.controller;

import com.faunjoe.demo.springbootstart.domain.Person;
import com.faunjoe.demo.springbootstart.event.FaunjoeApplicationContextAware;
import com.faunjoe.demo.springbootstart.event.FaunjoeEventPublisher;
import com.faunjoe.demo.springbootstart.event.MsgEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-11-27 14:40
 */

@RestController
public class PersonRestController {

    private final Person person;

    @Autowired
    private FaunjoeApplicationContextAware faunjoeApplicationContextAware;

    @Autowired
    private FaunjoeEventPublisher faunjoeEventPublisher;


    @Autowired
    public PersonRestController(Person person) {
        this.person = person;
    }

    @GetMapping("/person")
    public Person person() {
        faunjoeApplicationContextAware.publish(new MsgEvent(new Object(),"有人访问我，我得跟他们说:hello"));

        faunjoeEventPublisher.publish(new MsgEvent(new Object(),"有人访问我，我得跟他们说:hello"));
        return person;
    }
}
