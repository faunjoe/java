package com.kaikeba.dao;

import com.kaikeba.beans.Dept;

import java.util.List;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/19 11:18
 */
public interface DeptMapper {
    public void deptSave(Dept dept);
    public List<Dept> deptFind();
}

