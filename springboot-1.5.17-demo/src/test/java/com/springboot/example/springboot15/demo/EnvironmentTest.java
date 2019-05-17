package com.springboot.example.springboot15.demo;

import org.junit.Test;
import org.springframework.core.env.Environment;
import org.springframework.mock.env.MockEnvironment;

import static org.junit.Assert.*;

/**
 *
 * {@link Environment}
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/11/23 11:57
 */
public class EnvironmentTest {

    @Test
    public void testSystemProperty(){
        assertNotNull(System.getProperty("os.arch"));

        MockEnvironment environment = new MockEnvironment();

        environment.setProperty("user.country","EN");
        assertEquals("EN",environment.getProperty("user.country"));
    }

    @Test
    public void testManagementSecurityEnabled(){
        MockEnvironment environment = new MockEnvironment();

        environment.setProperty("management.security.enabled.security.enabled","true");
        assertTrue(environment.getProperty("management.security.enabled.security.enabled",boolean.class));
    }

    @Test
    public void testManagementSecurityDisabled(){
        MockEnvironment environment = new MockEnvironment();

        environment.setProperty("management.security.enabled.security.enabled","false");
        assertFalse(environment.getProperty("management.security.enabled.security.enabled",boolean.class));
    }
}
