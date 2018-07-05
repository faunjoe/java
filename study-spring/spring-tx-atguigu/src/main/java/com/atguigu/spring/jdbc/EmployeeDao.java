package com.atguigu.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/27 11:01
 */
@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee get(Integer id) {
        String sql = "SELECT id, last_name lastName, email FROM employees WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, id);

        return employee;
    }
}

