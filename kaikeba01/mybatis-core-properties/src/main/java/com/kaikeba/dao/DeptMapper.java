package com.kaikeba.dao;

import com.kaikeba.beans.Dept;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/17 11:26
 */
public interface DeptMapper {

    public Dept deptFindById(Integer deptno);

    public void saveDept(Dept dept);

}
