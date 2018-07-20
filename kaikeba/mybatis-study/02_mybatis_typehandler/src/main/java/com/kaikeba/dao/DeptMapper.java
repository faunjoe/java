package com.kaikeba.dao;


import com.kaikeba.beans.Dept;

import java.util.List;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/17 11:26
 */
public interface DeptMapper {

    Dept deptFindById(Integer deptno);

    List<Dept> deptFindList();

    void saveDept(Dept dept);

}
