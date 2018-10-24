package com.faunjoe.service;

import com.faunjoe.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 14:20
 */
@Service
public class BookService {

    @Qualifier("bookDao2")
    @Autowired(required=false)
    private BookDao bookDao;
    //private BookDao bookDao2;

    public void print(){
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService [bookDao=" + bookDao + "]";
    }
}
