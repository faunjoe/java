package com.kaikeba.util;

import com.kaikeba.service.SqlSession;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/19 14:07
 */
public class Invaction implements InvocationHandler {

    // 具体被监控对象
    private SqlSession obj;

    Connection connection;
    PreparedStatement pStatement;

    public Invaction(SqlSession obj) {
        this.obj = obj;
    }

    /**
     * invoke方法：在被监控行为将要执行时，会被JVM拦截
     * 被监控行为和行为实现方会被作为参数输送invoke
     * ****通知JVM,这个被拦截方法是如何与当前次要业务方法绑定实现
     * invoke方法三个参数
     * <p>
     * int v= 小明.eat();//JVM拦截
     * eat方法封装为Mehtod类型对象
     * eat方法运行时接受所有的实参封装到Object[]
     * 将负责监控小明的代理对象作为invoke方法第一个参数
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value;
        //1.执行JDBC初始次要业务
        init();
        //2.执行JDBC主要业务
        Field psField = obj.getClass().getDeclaredField("ps");
        psField.setAccessible(true);
        psField.set(obj, pStatement);
        value = method.invoke(obj, args);
        //3.执行JDBC结束次要业务
        close();
        //返回被拦截方法，需要调用地方
        return value;
    }

    private void init() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaikeba?characterEncoding=utf-8", "root",
                "123456");
        pStatement = connection.prepareStatement("");
    }

    private void close() throws Exception {
        if (pStatement != null) {
            pStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
