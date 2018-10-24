package com.faunjoe.controller;

import com.faunjoe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 14:20
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
