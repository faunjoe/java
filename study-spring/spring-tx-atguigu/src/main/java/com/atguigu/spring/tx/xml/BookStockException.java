package com.atguigu.spring.tx.xml;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/27 14:30
 */
public class BookStockException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BookStockException() {
        super();
    }

    public BookStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStockException(String message) {
        super(message);
    }

    public BookStockException(Throwable cause) {
        super(cause);
    }
}
