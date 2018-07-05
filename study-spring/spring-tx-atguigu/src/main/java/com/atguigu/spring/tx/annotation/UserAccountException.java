package com.atguigu.spring.tx.annotation;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/27 11:55
 */
public class UserAccountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserAccountException() {
        super();
    }

    public UserAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAccountException(String message) {
        super(message);
    }

    public UserAccountException(Throwable cause) {
        super(cause);
    }
}
